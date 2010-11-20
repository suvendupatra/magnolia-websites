<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<li>
	<cms:editBar editLabel="Edit Carousel Element" />
	<img src="${pageContext.request.contextPath}${content.image}" width="400" height="250" />
	<div class="carousel-text">${content.description}</div>
</li>
