<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty user ||null==user}">
<jsp:forward page="../Login/index.jsp"></jsp:forward>

</c:if>