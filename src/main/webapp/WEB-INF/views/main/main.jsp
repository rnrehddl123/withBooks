<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
    <div class="mainpage content">
      <div class="btn-group" role="group" aria-label="Basic outlined example">
        <button type="button" class="btn btn-outline-primary"><a href="novelList.do">글쓰기</a></button>
        <button type="button" class="btn btn-outline-primary">?</button>
        <button type="button" class="btn btn-outline-primary"><a href="listBoard">게시판</a></button>
      </div>


      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="resources/img/HarryPotter.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Harry Potter and the Deathly Hallows</h5>
              <p>해리의 열일곱 살 생일을 앞두고 더즐리 가족은 집을 떠난다. 해리가 마법사 세계 기준으로 성인이 되는 열일곱 살이 되는 순간, 더즐리네 집에 걸려 있던 보호 마법이 깨질 것이고, 볼드모트의 공격에 그대로 노출될 것이기 때문이다. 
              	  불사조 기사단은 생일을 하루 앞두고 해리를 안전하게 피신시키려 한다. 해리로 모습을 바꾼 여섯 명의 동료가 함께 빗자루를 타고 날아올라 흩어지는데, 어찌 된 일인지 죽음을 먹는 자들이 기다리고 있다가 이들을 공격한다. 
              	  간신히 은신처에 도착한 해리는 불행히도 조지의 부상, 매드아이 무디의 죽음, 먼덩거스의 도망을 전해 듣게 된다. 버로에 숨어 지내는 동안 덤블도어의 유품을 전해 받고, 한동안 평화롭게 지내던 해리와 친구들. 
              	  그러나 빌과 플뢰르의 결혼식날 죽음을 먹는 자들의 습격을 받는다. 간신히 탈출한 해리와 론과 헤르미온느는 호크룩스를 찾기 위해 헤매 다니게 되는데…</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="resources/img/goguruy.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>고구려</h5>
              <p>작가는 대한민국의 젊은이들이 고구려에 대해 알기를 바라는 마음으로 17년에 걸친 자료의 검토와 해석 끝에 이 소설을 냈다고 한다. 
              	  고구려의 가장 빛나는 시기였던 미천왕, 고국원왕, 소수림왕, 고국양왕, 광개토왕, 장수왕의 시대를 다룬다</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="resources/img/Sonagi.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>소나기</h5>
              <p>어느 가을날 한 줄기 소나기처럼 너무나 짧게 끝나버린 소년과 소녀의 안타깝고도 순수한 사랑을 그린 이야기를 다루고 있다. </p>
            </div>
          </div>
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
          <div class="carousel-item active">
            <div class="row">
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
              <div class="card col" style="width: 18rem;">
                <img src="resources/img/nav_logo.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
            </div>
          </div>
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
<jsp:include page="footer.jsp"/>