<%--
  Created by IntelliJ IDEA.
  User: 15371
  Date: 2020/6/26
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form method="post" action=""
${pageContext.request.contextPath}/reg.action">
UserName<input type="text" name="user.name"/><br/>
Password<input type="password" name="user.password"/><br/>
<input type="submit" value="reg">
</form>

</body>
</html>
