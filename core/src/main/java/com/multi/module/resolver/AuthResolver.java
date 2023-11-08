package com.multi.module.resolver;

import com.multi.module.anno.AuthLogin;
import com.multi.module.dto.AdminInfoDto;
import com.multi.module.dto.MemberInfoDto;
import com.multi.module.enums.UserRole;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class AuthResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthLogin.class) && (hasClassType(parameter.getParameterType()));
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        AuthLogin authLogin = parameter.getParameterAnnotation(AuthLogin.class);

        if (Objects.isNull(authLogin)) {
            return null;
        }

        //개인앱 로그인
        if (MemberInfoDto.class.isAssignableFrom(parameter.getParameterType())) {
            if (isPsn(authLogin) && isRequired(authLogin)) {
                return MemberInfoDto.builder().userPhone("010-1234-1234").userNick("userNick").build();
            }
        }
        else if (AdminInfoDto.class.isAssignableFrom(parameter.getParameterType())) {
            if (isAdmin(authLogin) && isRequired(authLogin)) {
                return AdminInfoDto.builder().userName("ADMIN_NAME").idx(1L).build();
            }
        }
        return null;
    }

    private boolean isPsn(AuthLogin authLogin) {
        return Objects.nonNull(authLogin) && authLogin.type().equals(UserRole.APP);
    }

    private boolean isRequired(AuthLogin authLogin) {
        return Objects.nonNull(authLogin) && authLogin.required();
    }

    private boolean isAdmin(AuthLogin authLogin) {
        return Objects.nonNull(authLogin) && authLogin.type().equals(UserRole.ADMIN);
    }

    private boolean hasClassType(Class<?>  parameterType){
        return (parameterType.equals(MemberInfoDto.class) || parameterType.equals(AdminInfoDto.class));
    }
}
