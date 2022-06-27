<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:include page="header.jsp"/>
    <div class="mainpage content">
      <div class="btn-group" role="group" aria-label="Basic outlined example">
        <button type="button" class="btn btn-outline-primary"><a href="novelList.do">글쓰기</a></button>
        <button type="button" class="btn btn-outline-primary"><a href="clientNovelListForCate">카테고리</a></button>
        <button type="button" class="btn btn-outline-primary"><a href="listBoard">게시판</a></button>
      </div>


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
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title"><a href="readBook">Title</a></h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title"><a href="readBook">Title</a></h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card">
              <div class="row no-gutters">
                  <div class="col-auto">
                      <img src="resources/img/nav_logo.png" class="img-fluid" alt="">
                  </div>
                  <div class="col">
                      <div class="card-block px-2">
                          <h4 class="card-title">Title</h4>
                          <p class="card-text">Description</p>
                      </div>
                  </div>
              </div>
            </div>
          </div>
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