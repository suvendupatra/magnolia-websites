<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="padding-left:10px;">
	<cms:editBar editLabel="Edit Like Paragraph" />
	<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
	<fb:like
		<c:if test="${content.url!=''}">href="${content.url}"</c:if>
		font="${content.font}"
		colorscheme="${content.scheme}">
		<fb:title><strong>${content.title}</strong></fb:title><br/>
	</fb:like>
</div>
