package com.htsvsystems.model.service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor @Data @NoArgsConstructor
public class AuthResponse  {

    private List<String> rolesList ;
    private Boolean isAuthenticated;
    private LocalDateTime lastLoggedIn;

   /* public void setRolesList(Collection<? extends GrantedAuthority> authorities) {
        authorities.stream().map( gt ->{
            
        })
    }*/

}
