<!DOCTYPE >
<html>
<head>
<title>Upload files</title>
<link href="uploadToDBstyle.css" rel="stylesheet" type="text/css"/>

</head>
<body>
 
    <div style="padding:5px; color:red;font-style:italic;">
       ${errorMessage}
    </div>
    
    <h2>Project Files Uploading</h2>
 
    <form method="post" action="${pageContext.request.contextPath}/uploadToDB"
        enctype="multipart/form-data">
        
        <p><u>Select File to Upload</u></p>
        <h3>Student Name: <input id="trisha3" type="text" placeholder="Enter Your Full Name" name="stuname" required/></h3>
        <h3>Select Your File <input id="trisha4" type="file" name="file" required/></h3>
        <b>Description:</b>
        <br/>
        <input id="trisha1" type="text" name="description" size="50" required />
        <br />
        <h5><input id="trisha2" type="submit" value="Upload" />      <a href="StudentHomePage.html">Back to home page?</a></h5>
    </form>
    
</body>
</html>