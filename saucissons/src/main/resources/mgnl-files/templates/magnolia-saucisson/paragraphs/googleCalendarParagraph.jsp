<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${content.title!=''}"><h4>${content.title}</h4></c:if>
<div style="padding-left:10px;overflow:scroll;">
	<cms:editBar editLabel="Edit Calendar" />
	<iframe src="http://www.google.com/calendar/embed?<c:if test="${content.showTitle==false}">showTitle=0&</c:if>height=${content.height}&amp;wkst=2&amp;bgcolor=%23${content.bgColor}&amp;src=${content.src}&amp;color=%23${content.fontColor}&amp;ctz=Australia%2FSydney" style=" border-width:0 " width="${content.width}" height="${content.height}" frameborder="0" scrolling="yes"></iframe>
</div>
