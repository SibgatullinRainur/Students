<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Page</title>
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>

<div class="tabs">
    <!-- Кнопка-переключатель и название первого таба -->
    <input type="radio" name="tabs" id="tab-first" checked >
    <label for="tab-first">
        <p>Students List</p>
    </label>
    <!-- Кнопка-переключатель и название второго таба -->
    <input type="radio" name="tabs" id="tab-second">
    <label for="tab-second">
        <p>Professors</p>
    </label>
    <!-- Кнопка-переключатель и название третьего таба -->
    <input type="radio" name="tabs" id="tab-third">
    <label for="tab-third">
        <p>Balls</p>
    </label>
    <!-- Вывод контента наших табов -->
    <div id="tab-content-1" class="tab-content">
        <p>
            <!-- контент под таб№1 -->
        <h1>Student List</h1>


        <table>
            <tr>
                <td width="60">ID</td>
                <td width="60">familyStudent</td>
                <td width="60">nameStudent</td>
                <td width="60">nameFatherStudent</td>
                <td width="60">birthdate</td>
                <td width="60">nameGroup</td>
                <td width="60">Edit</td>
                <td width="60">Delete</td>
            </tr>
            <c:forEach items="${listStudents}" var="students">
                <tr>
                    <td>${students.id}</td>
                    <td>${students.familyStudents}</td>
                    <td>${students.nameStudents}</td>
                    <td>${students.nameFatherStudents}</td>
                    <td>${students.birthdate}</td>
                    <td>${students.idGroup}</td>
                    <td><a href="/edit/${students.id}">Edit</a></td>
                    <td><a href="/remove/${students.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        </p>
        <div class="link_group">
            <a class="show_popup" rel="reg_form" href="#">Add</a>
            <div class="popup reg_form">
                <h2>Add a Student</h2>
                <url var="addAction" value="/index/addSt"/>
                <form action="${addAction}" commandName="students">
                    <table>
                        <if test="${!empty students.familyStudents}">
                            <tr>
                                <td>
                                    <label path="id">
                                        ID
                                    </label>
                                </td>
                                <td>
                                    <input path=${students.id} readonly="true" size="8" disabled="true"/>
                                    <hidden path="id"/>
                                </td>
                            </tr>
                        </if>
                        <tr>
                            <td>
                                <label path="familyStudents">
                                    Family
                                </label>
                            </td>
                            <td>
                                <input path=${students.familyStudents}/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <if test="${!empty students.familyStudents}">
                                    <input type="submit"
                                           value="EDIT"/>
                                </if>
                                <if test="${empty students.familyStudents}">
                                    <input type="submit"
                                           value="ADD"/>
                                </if>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div> <!-- #tab-content-1 -->
    <div id="tab-content-2" class="tab-content">
        <p><!-- контент под таб№2 -->
        <h1>Professors List</h1>


        <table>
            <tr>
                <td width="80">ID</td>
                <td width="120">nameGroup</td>
                <td width="60">Edit</td>
                <td width="60">Delete</td>
            </tr>
            <forEach items="${listGroups}" var="groups">
                <tr>
                    <td>${groups.id}</td>
                    <td><a href="/groupsdata/${groups.id}" target="_blank">${groups.nameGroup}</a></td>
                    <td><a href="/edit/${groups.id}">Edit</a></td>
                    <td><a href="/remove/${groups.id}">Delete</a></td>
                </tr>
            </forEach>
        </table>
        </p>
        <div class="link_group">
            <a class="show_popup" rel="reg_form" href="#">Add</a>
            <div class="popup reg_form">
                <h2>Add a Group</h2>
                <form method="post" action="">
                    <label for="login">Введите логин:</label>
                    <input type="text" name="login" />
                    <label for="password">Введите пароль:</label>
                    <input type="password" name="password" />
                    <input type="submit" value="Cancel" />
                    <input type="submit" value="Add" />
                </form>
            </div>
        </div>
    </div> <!-- #tab-content-2 -->
    <div id="tab-content-3" class="tab-content">
        <p>
            <!-- контент под таб№3 -->
        <h1>Balls</h1>


        <table>
            <tr>
                <td width="80">ID</td>
                <td width="120">nameGroup</td>
                <td width="60">Edit</td>
                <td width="60">Delete</td>
            </tr>
            <forEach items="${listGroups}" var="groups">
                <tr>
                    <td>${groups.id}</td>
                    <td><a href="/groupsdata/${groups.id}" target="_blank">${groups.nameGroup}</a></td>
                    <td><a href="/edit/${groups.id}">Edit</a></td>
                    <td><a href="/remove/${groups.id}">Delete</a></td>
                </tr>
            </forEach>
        </table>
        </p>
        <div class="link_group">
            <a class="show_popup" rel="reg_form" href="#">Add</a>
            <div class="popup reg_form">
                <h2>Add a Group</h2>
                <form method="post" action="">
                    <label for="login">Введите логин:</label>
                    <input type="text" name="login" />
                    <label for="password">Введите пароль:</label>
                    <input type="password" name="password" />
                    <input type="submit" value="Cancel" />
                    <input type="submit" value="Add" />
                </form>
            </div>
        </div>
    </div> <!-- #tab-content-3 -->
</div>

</body>
</html>
