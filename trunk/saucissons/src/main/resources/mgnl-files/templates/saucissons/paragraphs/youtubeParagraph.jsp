<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>
<div class="youtube-paragraph">
	<iframe
		title="${content.title}"
		class="youtube-player"
		type="text/html" 
		width="640"
		height="390"
		src="http://www.youtube.com/embed/${content.video}"
		frameborder="0">
	</iframe>
	<cms:editBar editLabel="Edit Youtube Video" />
</div>