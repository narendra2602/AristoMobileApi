package com.aristomobileapi.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aristomobileapi.dto.UserInfo;
import com.aristomobileapi.request.ChangePasswordRequest;
import com.aristomobileapi.request.LoginRequest;
import com.aristomobileapi.response.TokenResponse;
import com.aristomobileapi.service.TokenBlacklist;
import com.aristomobileapi.serviceimpl.JwtService;
import com.aristomobileapi.serviceimpl.UserInfoDetails;
import com.aristomobileapi.serviceimpl.UserInfoService;
import com.aristomobileapi.utility.AppRequestParameterUtils;


@CrossOrigin
@RestController
@RequestMapping("/auth") 
public class UserController { 
  
    @Autowired
    private UserInfoService service; 
  
    @Autowired
    private JwtService jwtService; 
  
    @Autowired
    private AuthenticationManager authenticationManager; 

    @Autowired
    private TokenBlacklist tokenBlacklist;
    
	@Autowired
	private AppRequestParameterUtils appRequestParameterUtils;

    
    @GetMapping("/welcome") 
    public String welcome() { 
        return "Welcome this endpoint is not secure"; 
    } 
  
    @PostMapping("/addNewUser") 
    public String addNewUser(@RequestBody UserInfo userInfo) { 
    	System.out.println(userInfo.getPassword());
    	System.out.println(userInfo.getLoginName());
    	System.out.println(userInfo.getUserType());
    	System.out.println(userInfo.getFname());
        return service.addUser(userInfo); 
    } 

    
    @PostMapping("/updateUser") 
    public String updateUser() { 
//    	System.out.println(userInfo.getPassword());
//    	System.out.println(userInfo.getLoginName());
//    	System.out.println(userInfo.getUserType());
//    	System.out.println(userInfo.getFname());
        return service.updateAllUser(); 
    } 

    
    @PostMapping("/changePassword") 
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request,HttpServletRequest req) { 

    	int requestValues[]=getRequestData(req);
        int loginId=requestValues[0]; 

        request.setUserId(loginId);
    	if(service.changePassword(request)==1)
        	return ResponseEntity.ok("Password Changes successfully");
        else
        	return ResponseEntity.ok("Error while Password Changed");
    } 
    
    @GetMapping("/user/userProfile") 
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public String userProfile() { 
        return "Welcome to User Profile"; 
    } 
  
    @GetMapping("/admin/adminProfile") 
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") 
    public String adminProfile() { 
        return "Welcome to Admin Profile"; 
    } 
  
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String token = extractTokenFromRequest(request);
        tokenBlacklist.addToBlacklist(token);

        // Clear any session-related data if necessary

        return ResponseEntity.ok("Logged out successfully");
    }
    
    @PostMapping("/generateToken") 
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody LoginRequest authRequest) { 
    	System.out.println(authRequest.getUsername());
    	System.out.println(authRequest.getPassword());
    	boolean passwordStatus = authRequest.getPassword().equals("123")?false:true;
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        
         
        UserInfoDetails userDetails = (UserInfoDetails) authentication.getPrincipal();
        
        
       // if (authentication.isAuthenticated()) { 
            String token =  jwtService.generateToken(authRequest.getUsername(),userDetails.getLoginId(),userDetails.getUserType(),userDetails.getFname());
            return new ResponseEntity<TokenResponse>(new TokenResponse(token,passwordStatus),HttpStatus.OK);
            //return ResponseEntity.ok(new AuthenticationResponse(token));
        //} else { 
          //  throw new UsernameNotFoundException("invalid user request !"); 
        //} 
    } 
  
    
    public String extractTokenFromRequest(HttpServletRequest request) {
        // Get the Authorization header from the request
        String authorizationHeader = request.getHeader("Authorization");

        // Check if the Authorization header is not null and starts with "Bearer "
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            // Extract the JWT token (remove "Bearer " prefix)
            return authorizationHeader.substring(7);
        }

        // If the Authorization header is not valid, return null
        return null;
    }
    
    
	private int[] getRequestData(HttpServletRequest req)
	{
		String authHeader = req.getHeader("Authorization");
		int requestValues[]=appRequestParameterUtils.getRequestBodyParameters(authHeader);
		return requestValues;
	}

} 