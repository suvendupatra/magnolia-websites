<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="paragraph-image">
	<c:if test="${not empty content.imageLink}">
		<a href="${content.imageLink}" target="_blank">
	</c:if>
	<img class="blason"
		src="${pageContext.request.contextPath}${content.image}"
		style="float:${content.imagePosition};"
		title="${content.imageName}"/>
	<label class="image-text">${content.imageName}</label>
	<c:if test="${not empty content.imageLink}">
		</a>
	</c:if>
	<cms:editBar editLabel="Edit Image" />
</div>
