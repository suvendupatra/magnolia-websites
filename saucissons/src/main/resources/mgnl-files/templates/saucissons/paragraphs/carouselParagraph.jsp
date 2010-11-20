<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>
<div id="carousel-${content.uuid}" class="carousel">
	<cms:newBar contentNodeCollectionName="CarouselParagraphs"
		paragraph="carousel-sub-paragraph"
		newLabel="Add an element to the carousel" />
	<ul>
		<cms:contentNodeIterator contentNodeCollectionName="CarouselParagraphs">
			<cms:includeTemplate />
		</cms:contentNodeIterator>
	</ul>
</div>
<cms:editBar editLabel="Edit Carousel" />

<script type="text/javascript">
$(function(){
	$('#carousel-${content.uuid}').infiniteCarousel({
		transitionSpeed : ${content.transitionSpeed},
		displayTime : ${content.displayTime},
		textholderHeight : .2,
		displayProgressBar : 0,
		displayThumbnails: ${content.displayThumbnails},
		displayThumbnailNumbers: 1,
		displayThumbnailBackground: 1,
		thumbnailWidth: '20px',
		thumbnailHeight: '20px',
		thumbnailFontSize: '.7em'
	});
});
</script>