package com.htsvsystems.model.service.request;

import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data @AllArgsConstructor @NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
    private String realm;
    private String roleName;
    private Map<String,String> headersMap;
    private List<Cookie> cookieList;
}
