<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Edit Header paragraph -->
<cms:editBar editLabel="Edit Header" />

<!-- Header paragraph content -->
<div class="header">
	<div class="headerLeft">
		<img id="logo" width="120px"
			height="100px" src="${pageContext.request.contextPath}${content.logo}" />
	</div>
	<div class="headerCenter">
		<span class="header">${content.text}</span>
	</div>
</div>