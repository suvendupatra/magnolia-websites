<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>
<div style="padding-left:10px;overflow:scroll;">
	<cms:editBar editLabel="Edit Calendar" />
	
	<c:url value="http://www.google.com/calendar/embed" var="url">
		<c:if test="${content.showTitle==false}">
			<c:param name="showTitle" value="0"/>
		</c:if>
		<c:param name="height" value="${content.height}"/>
		<c:param name="width" value="${content.width}"/>
		<c:param name="wkst" value="2"/>
		<c:param name="bgcolor" value="#${content.bgColor}"/>
		<c:param name="color" value="#${content.fontColor}"/>
		<c:param name="src" value="${content.src}"/>
		<c:param name="ctz" value="Australia/Sydney"/>
	</c:url>
	
	<iframe src="${url}" style="border-width:0;" width="${content.width}" height="${content.height}" frameborder="0" scrolling="yes"></iframe>

</div>
