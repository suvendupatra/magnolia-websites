<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="nested">
<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>

<!-- Counter to display subparagraphs on two columns -->
<c:set var="index" value="1" scope="request" />

<ul class="nested">
	<cms:contentNodeIterator
		contentNodeCollectionName="NestedSubParagraphs">
		<cms:includeTemplate />
	</cms:contentNodeIterator>
</ul>

<cms:newBar contentNodeCollectionName="NestedSubParagraphs"
	paragraph="saucisson-nested-sub-paragraph" newLabel="New Link" />

<cms:editBar editLabel="Edit Paragraph" />
</div>
