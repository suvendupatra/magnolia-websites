<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>
<div class="paragraph-gmap">
	<iframe width="${content.width}" height="${content.height}" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
		src="${content.gmapLink}&amp;output=embed">
	</iframe>
	
	<br />
	
	<small>
		<a href="${content.gmapLink}" style="color:#0000FF;text-align:left">View Larger Map</a>
	</small>
</div>

<cms:editBar editLabel="Edit Google Map" />
