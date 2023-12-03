<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/admin/product/enroll.css">
    <script src="/frontRepo/admin/js/msh/enrollProduct.js"></script>
</head>
<body>
    <header>
        <div class="header-inner">
            <div class="top-list">
                <ul>
                    <li><a href="">������</a></li>
                    <li><a href="">����������</a></li>
                    <li><a href="">����</a></li>
                    <li><a>�˸�</a></li>
                    <li><a href="">�α���</a></li>
                </ul>
            </div>
            <div class="main-list">
                <div class="logo-area">
                    <a href="">
                    <img src="./logo.svg">
                    <span>������</span>
                    </a>
                </div>
                <div class="head-list">
                    <ul>
                        <li><a href="">HOME</a></li>
                        <li><a href="">SHOP</a></li>
                        <li id="search-btn"><a><img src="./searchIcon.png"></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <br>        
        <div class="header-list">
            <a href=""><b><u>��ǰ���</u></b></a>
            <a href="">��ǰ����</a>
            <a href="">��ǰ����</a>
            <a href="">��ǰ���</a>
        </div>
    </header>
    <br><br>
    <hr>
    <br><br><br>
    <div class="side-body">
        <div class="sidebar">
            <a href="/admin"><h2>������ ������</h2></a>
            <br>
            <nav class="sidenav">
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">�ֹ�����</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="" class="menu_link">�԰� ��Ȳ</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">�˼����� ��Ȳ</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">��� ��Ȳ</a>
                        </li>
                    </ul>
                </div>
                <br>
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">��ǰ ����</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="" class="menu_link"><b><u>��ǰ���</u></b></a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">��ǰ ����</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">��ǰ ����</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">��ǰ ���</a>
                        </li>
                    </ul>
                </div>
                <br>
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">�� ����</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="" class="menu_link">��������</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">FAQ</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">Q&A</a>
                        </li>
                    </ul>
                </div>
            </div> 
            </nav>
            <div class="enroll-area">
                <input type="file" id="file-input" accept="image/*" onchange="previewImage(event)">
                <div>
                    <div id="image-preview-container" >
                        <img id="image-preview" src="#" alt="�̹��� �̸�����">
                    </div>
                    <div>
                        <label for="file-input" id="file-input-label" >�̹��� ����</label>
                    </div>
                </div>
                <br>
                <div id="product-information">
                    <form action="" method="post" >
                        <input type="text" name="productName" placeholder="��ǰ��">
                        <input type="text" name="modelNumber" placeholder="�� ��ȣ">
                        <input type="text" name="releasePrice" placeholder="�߸Ű�">
                        <input type="text" name="category" placeholder="ī�װ�">
                        <input type="text" name="brand" placeholder="�귣��">
                        <input type="date" name="releaseDate" placeholder="�����">
                        <span>������</span>
                        <div>
                            <input type="checkbox" name="size" value="210">210
                            <input type="checkbox" name="size" value="215">215
                            <input type="checkbox" name="size" value="220">220
                            <input type="checkbox" name="size" value="225">225
                            <input type="checkbox" name="size" value="230">230
                            <input type="checkbox" name="size" value="235">235
                            <input type="checkbox" name="size" value="240">240<br>  
                            <input type="checkbox" name="size" value="245">245
                            <input type="checkbox" name="size" value="250">250
                            <input type="checkbox" name="size" value="255">255
                            <input type="checkbox" name="size" value="260">260
                            <input type="checkbox" name="size" value="265">265
                            <input type="checkbox" name="size" value="270">270
                            <input type="checkbox" name="size" value="275">275<br>
                            <input type="checkbox" name="size" value="280">280
                            <input type="checkbox" name="size" value="285">285
                            <input type="checkbox" name="size" value="290">290
                            <input type="checkbox" name="size" value="295">295
                            <input type="checkbox" name="size" value="300">300

                        </div>
                        <input type="submit" value="����">
                        <button>���</button>
                    </form>
                </div>
                <br>
                
                
            </div>
        </div>
  <br><br><br><br><br><hr>
        <div class="service-container">
            <div class="menu-container">
                <div class="service-title">������</div>
                    <div class="first">
                        <ul>
                            <div><li><a href="">��������</a></li></div>
                            <div><li><a href="">���� ���� ����</a></li></div>
                            <div><li><a href="">Q&A</a></li></div>
                            <div><li><a href="">��ǰ��� ��û</a></li></div>
                        </ul>
                        <main>
                            
                        </main>
                    </div>
                   
            </div>
        </div>


</body>
</html>