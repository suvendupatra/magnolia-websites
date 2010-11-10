<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Start a new list when half of the subparagraphs have been displayed -->
<c:if test="${index > (size/2)}">
	<c:set var="index" value="1" scope="request" />
	</ul>
	<ul class="nested">
</c:if>

<li><a href="${content.link}">${content.text}</a> <cms:editBar
	editLabel="Edit Link" /></li>

<c:set var="index" value="${index + 1}" scope="request" />