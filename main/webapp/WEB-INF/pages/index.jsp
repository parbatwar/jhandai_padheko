<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<%@ include file="/jsp/header.jsp" %>

<div class="main-body">

    <!-- Poster -->
    <div class="poster-one">
        <img src="${pageContext.request.contextPath}/resources/images/books/library2.jpg">
        <div class="poster-info">
            <h1>Books to Freshen up<br>Your Bookshelf</h1>
            <p>DISCOVER, SHOP & ENJOY LEARNING</p>
            <button class="btn" style="padding: 16px 20px;">TAKE TOUR</button>
            <button class="btn" id="learn-more">LEARN MORE</button>
        </div>
    </div>

    <div class="main-content">

        <!-- Latest Products Section -->
        <section class="part">
            <div class="section-header">
                <p class="section-subtitle">FRESH OFF THE SHELF!</p>
                <h1 class="section-title">New Arrivals</h1>
            </div>

            <div class="latest-container">

                <!-- Book 1 -->
                <div style="background-color: #feefde;" class="latest-product">
                    <a href="#">
                        <div class="latest-product-img-wrapper">
                            <img src="${pageContext.request.contextPath}/resources/images/books/theAlchemiest.jpg" height="350px" alt="The Alchemist Front" class="product-img front" />
                            <img src="${pageContext.request.contextPath}/resources/images/books/alchemist2.png" height="350px" alt="The Alchemist Back" class="product-img back" />
                        </div>
                        <p style="color: #414141; font-size: 20px;"><b>The Alchemist</b></p>
                        <p style="font-size: 14px;">By Paulo Coehlo</p>
                    </a>
                </div>

                <!-- Book 2 -->
                <div style="background-color: #eeeeee;" class="latest-product">
                    <a href="#">
                        <div class="latest-product-img-wrapper">
                            <img src="${pageContext.request.contextPath}/resources/images/books/theMountainIsYou.jpg" height="350px" alt="The Mountain Is You Front" class="product-img front" />
                            <img src="${pageContext.request.contextPath}/resources/images/books/mountainisyou2.jpg" height="350px" alt="The Mountain Is You Back" class="product-img back" />
                        </div>
                        <p style="color: #414141; font-size: 20px;"><b>The Mountain Is You</b></p>
                        <p style="font-size: 14px;">By Brianna Wiest</p>
                    </a>
                </div>

                <!-- Book 3 -->
                <div style="background-color: #f8e8f4;" class="latest-product">
                    <a href="#">
                        <div class="latest-product-img-wrapper">
                            <img src="${pageContext.request.contextPath}/resources/images/books/itEndsWithUs.jpg" height="350px" alt="It Ends With Us Front" class="product-img front" />
                            <img src="${pageContext.request.contextPath}/resources/images/books/endswithus2.jpg" height="350px" alt="It Ends With Us Back" class="product-img back" />
                        </div>
                        <p style="color: #414141; font-size: 20px;"><b>It Ends With Us</b></p>
                        <p style="font-size: 14px;">By Colleen Hoover</p>
                    </a>
                </div>

            </div>
        </section>

        <!-- Categories Section -->
        <section class="part">
            <div class="section-header">
                <p class="section-subtitle">TOP CATEGORIES</p>
                <h1 class="section-title">Explore Categories</h1>
            </div>
            <div class="categories-container">
                <div class="c-container">
                    <a href="#" class="c-c-container">
                        <div class="icon-text-wrapper">
                            <i class="fas fa-paint-brush"></i>
                            <div class="text-content">
                                <h2>Art & Design</h2>
                                <p>300 Books</p>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="c-c-container">
                        <div class="icon-text-wrapper">
                            <i class="fas fa-briefcase"></i>
                            <div class="text-content">
                                <h2>Business</h2>
                                <p>450 Books</p>
                            </div>
                        </div>
                    </a>
                </div>

                <a href="#" style="width: 300px; height: auto;" class="c-c-container">
                    <div class="icon-text-wrapper">
                        <i class="fas fa-laptop-code" style="margin-bottom:40px;"></i>
                        <div class="text-content">
                            <h2>IT & Technology</h2>
                            <p>900 Books</p>
                        </div>
                    </div>
                </a>

                <div class="c-container">
                    <a href="#" class="c-c-container">
                        <div class="icon-text-wrapper">
                            <i class="fas fa-chart-line"></i>
                            <div class="text-content">
                                <h2>Financial</h2>
                                <p>700 Books</p>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="c-c-container">
                        <div class="icon-text-wrapper">
                            <i class="fas fa-notes-medical"></i>
                            <div class="text-content">
                                <h2>Medicine</h2>
                                <p>1000 Books</p>
                            </div>
                        </div>
                    </a>
                </div>

                <div class="c-container">
                    <a href="#" class="c-c-container">
                        <div class="icon-text-wrapper">
                            <i class="fas fa-headphones"></i>
                            <div class="text-content">
                                <h2>Audio Books</h2>
                                <p>300 Books</p>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="c-c-container">
                        <div class="icon-text-wrapper">
                            <i class="fas fa-atom"></i>
                            <div class="text-content">
                                <h2>Science</h2>
                                <p>300 Books</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </section>

        <!-- Best Selling Section -->
        <section class="part">
            <div class="section-header">
                <p class="section-subtitle">TRENDING BOOK REVIEW</p>
                <h1 class="section-title">Do Not Miss These</h1>
            </div>

            <div style="padding: 80px;" class="best-selling">

                <!-- Selling Card 1 -->
                <div class="selling-card">
                    <a style="text-decoration: none;" href="#">
                        <img src="${pageContext.request.contextPath}/resources/images/books/RichDadPoorDad.jpg" height="300px" alt="Rich Dad Poor Dad" />
                        <div class="card-info">
                            <p style="color: #1771d9; font-size: 20px;"><b>₹450.00</b></p>
                            <p style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;"><b>Rich Dad Poor Dad</b></p>
                            <p style="color: #747474; font-size: 14px;">By Robert T. Kiyosaki</p>
                        </div>
                    </a>
                </div>

                <!-- Selling Card 2 -->
                <div class="selling-card">
                    <a style="text-decoration: none;" href="${pageContext.request.contextPath}/bookview">
                        <img src="${pageContext.request.contextPath}/resources/images/books/1984.png" height="300px" alt="1984" />
                        <div class="card-info">
                            <p style="color: #1771d9; font-size: 20px;"><b>₹800.00</b></p>
                            <p style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;"><b>1984</b></p>
                            <p style="color: #747474; font-size: 14px;">By George Orwell</p>
                        </div>
                    </a>
                </div>

                <!-- Selling Card 3 -->
                <div class="selling-card">
                    <a style="text-decoration: none;" href="#">
                        <img src="${pageContext.request.contextPath}/resources/images/books/atomichabits.jpg" height="300px" alt="Atomic Habits" />
                        <div class="card-info">
                            <p style="color: #1771d9; font-size: 20px;"><b>₹750.00</b></p>
                            <p style="color: #414141; font-weight: 500; font-size: 20px; max-width: 300px;"><b>Atomic Habits</b></p>
                            <p style="color: #747474; font-size: 14px;">By James Clear</p>
                        </div>
                    </a>
                </div>

                <!-- Selling Card 4 -->
                <div class="selling-card">
                    <a style="text-decoration: none;" href="#">
                        <img src="${pageContext.request.contextPath}/resources/images/books/whiteTiger.jpeg" height="300px" alt="The White Tiger" />
                        <div class="card-info">
                            <p style="color: #1771d9; font-size: 20px;"><b>₹400.00</b></p>
                            <p style="color: #414141; font-weight: 500; font-size: 20px; max-width: 280px;"><b>The White Tiger</b></p>
                            <p style="color: #747474; font-size: 14px;">By Aravind Adiga</p>
                        </div>
                    </a>
                </div>
            </div>
        </section>
        
        <section class="part">
        	<div style="padding: 16px 80px 80px 80px;" class="best-selling">
            
              <div class="selling-card">
                <a style="text-decoration: none;" href="#">
					<img src="${pageContext.request.contextPath}/resources/images/books/romeo-and-juliet.jpg" height="300px" alt="Romeo and Juliet" />
                  <div class="card-info">
                    <p style="color: #1771d9; font-size: 20px;"><b>₹500.00</b></p>
                    <p style="color: #414141; font-weight:500; font-size: 20px; max-width: 280px;"><b>Romeo and Juliet</b></p>
                    <p style="color: #747474; font-size: 14px;">By William Shakespeare</p>
                  </div>
                </a>
              </div>
      
              <div class="selling-card">
                <a style="text-decoration: none;" href="#">
					<img src="${pageContext.request.contextPath}/resources/images/books/gonegirl.jpg" height="300px" alt="Gone Girl" />
                  <div class="card-info">
                    <p style="color: #1771d9; font-size: 20px;"><b>₹700.00</b></p>
                    <p style="color: #414141; font-weight:500; font-size: 20px; max-width: 280px;"><b>Gone Girl</b></p>
                    <p style="color: #747474; font-size: 14px;">By Gillian Flynn</p>
                  </div>
                </a>
              </div>
      
              <div class="selling-card">
                <a style="text-decoration: none;" href="#">
					<img src="${pageContext.request.contextPath}/resources/images/books/Thenotebook.jpg" height="300px" alt="The Notebook" />
                  <div class="card-info">
                    <p style="color: #1771d9; font-size: 20px;"><b>₹650.00</b></p>
                    <p style="color: #414141; font-weight:500; font-size: 20px; max-width: 300px;"><b>The Notebook</b></p>
                    <p style="color: #747474; font-size: 14px;">By Nicholas Sparks</p>
                  </div>
                </a>
              </div>

              <div class="selling-card">
                <a style="text-decoration: none;" href="#">
					<img src="${pageContext.request.contextPath}/resources/images/books/why-we-sleep.jpg" height="300px" alt="Why We Sleep" />
                  <div class="card-info">
                    <p style="color: #1771d9; font-size: 20px;"><b>₹550.00</b></p>
                    <p style="color: #414141; font-weight:500; font-size: 20px; max-width: 280px;"><b>Why We Sleep</b></p>
                    <p style="color: #747474; font-size: 14px;">By Matthew Walker</p>
                  </div>
                </a>
              </div>
        	</div>
        </section>         

        <!-- Show More Section -->
        <section class="part" style="display: flex; justify-content: center; margin-top: 40px;">
            <div class="show-more">
                <div class="title">
                    <h1 style="font-weight: 700; font-size: 100px; color: #1771d9; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.4);">
                        Library? <br> It’s Online Now.</h1>
                </div>
                <div id="show-content">
                    <p style="text-align: center; line-height: 1.75;">Browse, buy, rent, or read your favorite titles all in one place. 
                    Whether you’re here to study, escape into a story, or just explore, our shelves are open 24/7. 
                    Because learning never stops, and neither should your reading journey.</p><br>
                </div>
            </div>
        </section>

        <!-- Author Section -->
        <div>
            <div class="author-container">
                <img src="${pageContext.request.contextPath}/resources/images/books/Screenshot.jpg" id="author-img">
                <button class="a-btn">Add to Wishlist</button>
            </div>
        </div>

    </div>
</div>

<%@ include file="/jsp/footer.jsp" %>

</body>
</html>