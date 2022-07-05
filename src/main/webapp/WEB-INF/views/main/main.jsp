<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"/>
    <div class="mainpage content">
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <c:forEach items="${listSlide}" var="sdto">
          <div class="carousel-item">
            <img src="resources/slideImages/${sdto.slidet_image}" class="d-block w-100" alt="..." height = "500" width="800">
            <div class="carousel-caption d-none d-md-block">
            </div>
          </div>
          </c:forEach>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>


      <div class="container left_card">
        <div class="row">
         <c:forEach items="${relist}" var="redto">	
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title"><a href="readBook">${redto.novel_subject}</a></h4>
                          <p class="card-text">${redto.novel_summary}</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
         </c:forEach> 
        </div>
        
        <div class="row">
         <c:forEach items="${urelist}" var="uredto">	
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title"><a href="readBook">${uredto.novel_subject}</a></h4>
                          <p class="card-text">${uredto.novel_summary}</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
         </c:forEach> 
        </div>
        
        <div class="row">
         <c:forEach items="${arelist}" var="aredto">	
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title"><a href="readBook">${aredto.novel_subject}</a></h4>
                          <p class="card-text">${aredto.novel_summary}</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
         </c:forEach> 
        </div>
        
      </div>
      <div id="carouselExampleControls" class="carousel slide cardslide" data-bs-ride="carousel">
        <div class="carousel-inner">
           <c:forEach items="${sslist}" var="cslist">
            	<div class="carousel-item carousel-items ">
            		<div class="row">
             	<c:forEach items="${cslist}" var="sudto">
             		<c:forEach items="${listNovel}" var="ndto">
             			<c:if test="${ndto.nnum eq sudto.nnum}">
              				<div class="card col" style="width: 18rem;" align="center">
              					<div class="card-image">
                					<img src="resources/img/${ndto.novel_image}" class="card-img-top" alt="..." width="19%" height="200">
                				</div>
                				<div class="card-body">
                  				<h5 class="card-title">${sudto.suggestNovel}</h5>
                  				<p class="card-text">${ndto.novel_summary}</p>
                  				<a href="clientNovelInfo?nnum=${ndto.nnum}&change=now" class="btn btn-primary">소설 읽기</a>
                				</div>
                			</div>
             			</c:if>
             		</c:forEach>
             	</c:forEach>
             	</div>
         		 </div>
             </c:forEach>
        </div>
               <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>

      </div>
      
<script type="text/javascript">
	var firstslide =document.querySelector('.carousel-item');
	firstslide.classList.add("active");
	var firstslides =document.querySelector('.carousel-items');
	firstslides.classList.add("active");
</script>
<jsp:include page="footer.jsp"/>