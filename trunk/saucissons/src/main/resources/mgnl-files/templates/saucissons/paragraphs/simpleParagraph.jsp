<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>
<div class="rightbg">
	<div><img src="${pageContext.request.contextPath}${content.image}" style="padding:0px 15px;float:${content.imagePosition};"/></div>
	<div>${content.description}</div>
	<cms:editBar editLabel="Edit Paragraph" />
</div>
