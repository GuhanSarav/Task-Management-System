# Struts2 REST + Non REST action

## struts.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
   "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
   "http://struts.apache.org/dtds/struts-2.0.dtd">

	<struts>    

		<constant name="struts.ui.theme" value="simple" />

		<constant name="struts.action.extension" value="xhtml,,xml,json,action" />

		<!-- Its not a mandatory to set 'Controller' at the end of REST actions -->
		<constant name="struts.convention.action.suffix" value="Action, Controller" />
    	<constant name="struts.convention.action.mapAllMatches" value="true" />
    	<constant name="struts.convention.default.parent.package" value="rest-default" />

    	<!-- package name of REST controllers (only last part of package) -->
    	<constant name="struts.convention.package.locators" value="rest" />

		<constant name="struts.mapper.class" value="org.apache.struts2.dispatcher.mapper.PrefixBasedActionMapper" />

		<!-- /api is the namespace of REST calls, second part "struts" for Non-REST calls -->
		<constant name="struts.mapper.prefixMapping" value="/api:rest,:struts"/>

        <!-- set name space for REST, it should match with "struts.mapper.prefixMapping"-->
    	<constant name="struts.rest.namespace" value="/api" />

    	<!-- Default extension for REST calls -->
    	<constant name="struts.rest.defaultExtension" value="json" />

		<package name="default" namespace="/" extends="struts-default, json-default">

			<action name="users" class="com.aurum.struts.nonrest.UserAction">
				<result name="success">/WEB-INF/jsp/user/list.jsp</result>
			</action>

		</package>

		<package name="api" namespace="/api" extends="rest-default">
			<action name="users/*" class="com.aurum.struts.rest.UserController">
				<param name="id">{1}</param>
			</action>
		</package>

	</struts>

```      

## For REST

```
GET      http://localhost:8080/struts2-rest-nonrest/api/users
POST     http://localhost:8080/struts2-rest-nonrest/api/users
PUT      http://localhost:8080/struts2-rest-nonrest/api/users
GET      http://localhost:8080/struts2-rest-nonrest/api/users/{id}
DELETE   http://localhost:8080/struts2-rest-nonrest/api/users/{id}
```

## For Non-Rest actions

```
http://localhost:8080/struts2-rest-nonrest/users
```
