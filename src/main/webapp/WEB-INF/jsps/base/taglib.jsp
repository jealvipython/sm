<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
 <c:set var="sm" value="${pageContext.request.contextPath}"/> 
<c:set var="smStatic" value="${pageContext.request.contextPath}/static"/>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${smStatic}/css/utils/sweetAlert/sweetalert.css" />
<script type="text/javascript" src="${smStatic}/js/lib/sweetAlert/sweetalert-dev.js"> </script>
<script type="text/javascript" src="${smStatic}/js/lib/sweetAlert/sweetalert.min.js"> </script>

<script type="text/javascript">




	function onFormSubmit(form){
		$(form).find("select").attr("disabled",false);
	}
	function setSort(value){
		var sort = $("#frontSort").val();
		var isDesc = sort.indexOf("DESC");
		if(isDesc==-1 && sort==value){
			$("#frontSort").val(value+" DESC");
		}else{
			$("#frontSort").val(value);
		}
		$("#btnSubmit").click();
	};
</script>