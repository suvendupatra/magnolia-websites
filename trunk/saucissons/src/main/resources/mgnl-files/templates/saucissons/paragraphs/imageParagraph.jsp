<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<img class="blason" src="${pageContext.request.contextPath}${content.image}" style="float:${content.imagePosition};"/>
<cms:editBar editLabel="Edit Image" />
