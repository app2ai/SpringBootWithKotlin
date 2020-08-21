/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vr.api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2 
import springfox.documentation.builders.PathSelectors.regex
/*
  @author Vishal
  Created on 21 Aug, 2020
*/

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    fun kotlinApiSwagger():Docket{
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vr.api.webs"))
                .paths(regex("/v1.*"))
                .build()
    } 
}