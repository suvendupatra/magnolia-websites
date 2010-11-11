<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="contentRight">
	<!-- Content Paragraphs-->
	<c:set var="index" value="1" scope="request" />
	<cms:contentNodeIterator contentNodeCollectionName="ContentParagraphs">
		<cms:includeTemplate />
		<c:if test="${index < (size)}">
			<div class="rightcenter"></div>
		</c:if>
		<c:set var="index" value="${index + 1}" scope="request" />
	</cms:contentNodeIterator>

	<cms:adminOnly>
		<br/>
	</cms:adminOnly>
	<cms:newBar contentNodeCollectionName="ContentParagraphs"
		paragraph="saucisson-simple-paragraph, saucisson-nested-paragraph,
					facebook-like-paragraph, facebook-comment-paragraph,
					google-calendar-paragraph, contact-paragraph"
		newLabel="Add Content to Page" />
</div>