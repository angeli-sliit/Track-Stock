/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-09-18 16:23:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Admin.UserManagement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import auth.DbConn;

public final class editaccess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/Admin/UserManagement/../Dashboard/headeradmin.jsp", Long.valueOf(1726578838339L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("jakarta.servlet.http.HttpSession");
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("auth.DbConn");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write('\n');
      out.write('\n');
   HttpSession se1 = request.getSession();
	 String username = (String) se1.getAttribute("username");

      out.write("\n");
      out.write("  \n");
 HttpSession Se1 = request.getSession(); 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    \n");
      out.write("       <link rel=\"icon\" type=\"image/x-icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/src/icon.png\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css\">\n");
      out.write("    <style>\n");
      out.write("    body{\n");
      out.write("  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\n");
      out.write("  font-weight: 400;\n");
      out.write("  overflow-x: hidden;\n");
      out.write("  overflow-y: auto;\n");
      out.write("  background: #f1f2f7;\n");
      out.write("  height: 100%;\n");
      out.write("  width: 100%;\n");
      out.write("}a{\n");
      out.write("  color #777;\n");
      out.write("  text-decoration: none;\n");
      out.write("}.padding-top{\n");
      out.write("  padding-top: 20px;\n");
      out.write("}.login-page{\n");
      out.write("  width: 350px;\n");
      out.write("  margin: 5% 40% 6% auto;\n");
      out.write("  padding: 0 20px;\n");
      out.write("  background-color: #f9f9f9;\n");
      out.write("  border: 1px solid #f2f2f2;\n");
      out.write("}.login-page .text-center{\n");
      out.write("  margin-bottom: 10px;\n");
      out.write("}.box{\n");
      out.write("  padding: 20px;\n");
      out.write("  background-color: #f9f9f9;\n");
      out.write("  border: 1px solid #f2f2f2;\n");
      out.write("}.page{\n");
      out.write("  position: relative;\n");
      out.write("  display: block;\n");
      out.write("  top: 50px;\n");
      out.write("  left: 0;\n");
      out.write("  padding: 35px 15px 20px 270px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".page-lgn{\n");
      out.write("  position: relative;\n");
      out.write("  display: block;\n");
      out.write("  top: 50px;\n");
      out.write("  left: 0;\n");
      out.write("  padding: 35px 15px 20px 270px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".bg-green{\n");
      out.write("  background-color: #A3C86D;\n");
      out.write("}\n");
      out.write(".bg-blue{\n");
      out.write("  background-color: #7ACBEE;\n");
      out.write("}\n");
      out.write(".bg-yellow{\n");
      out.write("  background-color: #FDD761;\n");
      out.write("}\n");
      out.write(".bg-red{\n");
      out.write("  background-color: #FF7857;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".bg-secondary1{\n");
      out.write("	background-color: #b17897;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".bg-blue2{\n");
      out.write("	background-color: #7a83ee;\n");
      out.write("}\n");
      out.write(".panel-default >.panel-heading{\n");
      out.write("  background-color: #f5f5f5;\n");
      out.write("  border-bottom: 2px solid #3498DB;\n");
      out.write("  font-size: 15px;\n");
      out.write("  text-transform: uppercase;\n");
      out.write("  letter-spacing: .5px;\n");
      out.write("  padding: 15px;\n");
      out.write("}.panel-box{\n");
      out.write("  width: 100%;\n");
      out.write("  height: 100%;\n");
      out.write("  text-align: center;\n");
      out.write("  border: none;\n");
      out.write("}.panel-value{\n");
      out.write("  width: 60%;\n");
      out.write("}.panel-icon{\n");
      out.write("  padding: 30px;\n");
      out.write("  width: 40%;\n");
      out.write("  border-radius: 0;\n");
      out.write("}.panel-icon{\n");
      out.write("  -webkit-border-radius: 3px 0 0 3px;\n");
      out.write("  -moz-border-radius: 3px 0 0 3px;\n");
      out.write("  border-radius: 3px 0 0 3px;\n");
      out.write("}.panel-value{\n");
      out.write("  -webkit-border-radius: 0 3px 3px 0;\n");
      out.write("  -moz-border-radius: 0 3px 3px 0;\n");
      out.write("  border-radius: 0 3px 3px 0;\n");
      out.write("}.panel-value h2{\n");
      out.write("  margin-top: 30px;\n");
      out.write("}\n");
      out.write(".panel-icon i{\n");
      out.write("  line-height:65px;\n");
      out.write("  font-size: 40px;\n");
      out.write("  color: #fff;\n");
      out.write("}\n");
      out.write("#header {\n");
      out.write("  position: fixed;\n");
      out.write("  z-index: 99;\n");
      out.write("  top: 0;\n");
      out.write("  left: 0;\n");
      out.write("  background-color: #fff;\n");
      out.write("  width: 100%;\n");
      out.write("  height: 65px;\n");
      out.write("  line-height: 65px;\n");
      out.write("  -moz-box-shadow: 0 1px 2px rgba(0,0,0,0.1);\n");
      out.write("  -webkit-box-shadow: 0 1px 2px rgba(0,0,0,0.1);\n");
      out.write("   box-shadow: 0 1px 2px rgba(0,0,0,0.1);\n");
      out.write("} header > .logo {\n");
      out.write("    color: #fff;\n");
      out.write("    text-align: center;\n");
      out.write("    font-weight: 700;\n");
      out.write("    text-transform: uppercase;\n");
      out.write("    letter-spacing: 1px;\n");
      out.write("    display: inline-block;\n");
      out.write("    width: 250px;\n");
      out.write("    background-color: #db3434;\n");
      out.write("}.header-date{\n");
      out.write("  color: #9b9b9b;\n");
      out.write("  margin-left: 20px;\n");
      out.write("}\n");
      out.write(".info-menu{\n");
      out.write("  height: 60px;\n");
      out.write("  margin: 0;\n");
      out.write("  line-height: 60px;\n");
      out.write("  padding: 0 15px;\n");
      out.write("}.info-menu li.profile {\n");
      out.write("  position: relative;\n");
      out.write("}.profile a.toggle{\n");
      out.write("  text-decoration: none;\n");
      out.write("  text-align: center;\n");
      out.write("  font-size: 14px;\n");
      out.write("  color: rgba(150, 150, 158, 1.0);\n");
      out.write("  position: relative;\n");
      out.write("  padding: 10px 10px 10px 0;\n");
      out.write("  margin: 0;\n");
      out.write("  background: #f9f9f9;\n");
      out.write("  border-radius: 30px;\n");
      out.write("}.info-menu li.profile a img{\n");
      out.write("  width: 30px;\n");
      out.write("  height: 30px;\n");
      out.write("}.dropdown-menu{\n");
      out.write("  margin-top: 4px;\n");
      out.write("  border-color: #fefefe;\n");
      out.write("  border-radius: 0;\n");
      out.write("   box-shadow: 0px 0px 5px rgba(86, 96, 117, 0.15);\n");
      out.write("  -moz-box-shadow: 0px 0px 5px rgba(86, 96, 117, 0.15);\n");
      out.write("  -webkit-box-shadow: 0px 0px 5px rgba(86, 96, 117, 0.15);\n");
      out.write("  }.dropdown-menu li{\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    display: block;\n");
      out.write("    line-height: 35px;\n");
      out.write(" }.dropdown-menu li a{\n");
      out.write("  text-decoration: none;\n");
      out.write("  display: block;\n");
      out.write("  font-size: 14px;\n");
      out.write("  position: relative;\n");
      out.write("  line-height: 30px;\n");
      out.write("  width: 100%;\n");
      out.write("  border-bottom: 1px solid #f4faf9;\n");
      out.write("}.dropdown-menu li a i{\n");
      out.write("  margin-right: 5px;\n");
      out.write("}.dropdown-menu li.last a{\n");
      out.write("  border-bottom: 0;\n");
      out.write("}.datepicker{\n");
      out.write("  text-align: center;\n");
      out.write("}\n");
      out.write(".sidebar {\n");
      out.write("  position: fixed;\n");
      out.write("  z-index: 10;\n");
      out.write("  left: 0;\n");
      out.write("  top: 0;\n");
      out.write("  padding: 65px 0 0;\n");
      out.write("  height: 100%;\n");
      out.write("  width: 250px;\n");
      out.write("  background: #272727;\n");
      out.write("  border-right: 1px solid #ddd;\n");
      out.write("  text-align: center;\n");
      out.write("}.sidebar ul li:hover,.submenu ul li:hover{\n");
      out.write("  -webkit-transition: all .2s ease-in-out;\n");
      out.write("  transition: all .2s ease-in-out;\n");
      out.write("}.sidebar ul{\n");
      out.write("  list-style: none;\n");
      out.write("  margin: 0;\n");
      out.write("  padding: 0;\n");
      out.write("}.sidebar ul li {\n");
      out.write("  display: block;\n");
      out.write("}.sidebar ul li:hover,ul.submenu{\n");
      out.write("  background-color:#35404d;\n");
      out.write("}.sidebar ul li a:hover {\n");
      out.write("  color: white;\n");
      out.write("}.sidebar ul li a,ul.submenu li a {\n");
      out.write("  color: #aeb2b7;\n");
      out.write("  display: block;\n");
      out.write("  overflow: hidden;\n");
      out.write("  position: relative;\n");
      out.write("  white-space: nowrap;\n");
      out.write("  text-decoration: none;\n");
      out.write("  text-align: left;\n");
      out.write("}.sidebar ul li a span,.sidebar ul li i{\n");
      out.write("  font-size: 14px;\n");
      out.write("  font-weight: 300;\n");
      out.write("  letter-spacing: 1.5px;\n");
      out.write("  text-shadow: 0 1px rgba(0,0,0, 1);\n");
      out.write("}.sidebar ul li a i{\n");
      out.write("  color: #aeb2b7;\n");
      out.write("  padding: 15px 22px;\n");
      out.write("  text-align: center;\n");
      out.write("}ul.submenu{\n");
      out.write("  display: none;\n");
      out.write("  position: relative;\n");
      out.write("}ul.submenu li a:hover{\n");
      out.write("  background-color:#35404d;\n");
      out.write("}ul.submenu li a {\n");
      out.write("  padding-left: 45px;\n");
      out.write("}ul.submenu li:before{\n");
      out.write("  content: \"\";\n");
      out.write("  display: block;\n");
      out.write("  position: absolute;\n");
      out.write("  z-index: 1;\n");
      out.write("  left: 25px;\n");
      out.write("  top: 0;\n");
      out.write("  bottom: 0;\n");
      out.write("  border: 1px dotted #d7d7d7;\n");
      out.write("  border-width: 0 0 0 1px;\n");
      out.write("}ul.submenu li a:before{\n");
      out.write("  content: \"\";\n");
      out.write("  display: inline-block;\n");
      out.write("  position: absolute;\n");
      out.write("  width: 7px;\n");
      out.write("  left: 25px;\n");
      out.write("  top: 18px;\n");
      out.write("  border-top: 1px dotted #d7d7d7;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sale_report_header{\n");
      out.write("  padding: 15px 0;\n");
      out.write("}\n");
      out.write("table td h6{\n");
      out.write("  margin: 0 0 0.2em 0;\n");
      out.write("}\n");
      out.write("table tfoot tr td:first-child{\n");
      out.write("  border: 0;\n");
      out.write("}table tfoot tr td:last-child{\n");
      out.write("  border-top: 1px solid #ccc;\n");
      out.write("}table td h6,table tfoot tr td:last-child{\n");
      out.write("  color: #000;\n");
      out.write("  _font-size: 1.2em;\n");
      out.write("  font-weight: normal;\n");
      out.write("}\n");
      out.write(".form-control{\n");
      out.write("  color: #646464;\n");
      out.write("  border: 1px solid #e6e6e6;\n");
      out.write("  border-radius: 3px;\n");
      out.write("  -webkit-box-shadow: none;\n");
      out.write("  -moz-box-shadow: none;\n");
      out.write("  box-shadow: none;\n");
      out.write("  -moz-transition: all .15s ease-out;\n");
      out.write("  -webkit-transition: all .15s ease-out;\n");
      out.write("  transition: all .15s ease-out;\n");
      out.write("}.form-control:focus{\n");
      out.write("  background: #f8f8f8;\n");
      out.write("  border-color: #3498DB;\n");
      out.write("  outline: 0;\n");
      out.write("  -webkit-box-shadow: none;\n");
      out.write("  -moz-box-shadow: none;\n");
      out.write("  box-shadow: none;\n");
      out.write("}\n");
      out.write(".btn{\n");
      out.write("  border-radius: 3px;\n");
      out.write("  -webkit-transition: all 300ms ease-in-out;\n");
      out.write("  -moz-transition: all 300ms ease-in-out;\n");
      out.write("   transition: all 300ms ease-in-out;\n");
      out.write("}.btn-primary {\n");
      out.write("    color: #fff;\n");
      out.write("    background-color: #51aded;\n");
      out.write("    border-color: #3d8fd8\n");
      out.write("}.btn-primary:hover, .btn-primary:focus, .btn-primary.focus, .btn-primary:active, .btn-primary.active{\n");
      out.write("    color: #fff;\n");
      out.write("    background-color: #3175b8;\n");
      out.write("    border-color: #3d8fd8\n");
      out.write("}.btn-success{\n");
      out.write("   background-color:#2ecc71\n");
      out.write("}.btn-success:hover, .btn-success:focus, .btn-success.focus, .btn-success:active, .btn-success.active{\n");
      out.write("  background-color:#27ae60\n");
      out.write("}.btn-warning{\n");
      out.write("  background-color: #e7c13e;\n");
      out.write("  border-color: #dfba3c;\n");
      out.write("}.btn-warning:hover, .btn-warning:focus, .btn-warning.focus, .btn-warning:active, .btn-warning.active{\n");
      out.write("  background-color:#d0ac2c;\n");
      out.write("  border-color: #dfba3c;\n");
      out.write("}.btn-danger{\n");
      out.write("  background-color: #ed5153\n");
      out.write("}.btn-danger:hover, .btn-danger:focus, .btn-danger.focus, .btn-danger:active, .btn-danger.active{\n");
      out.write("  background-color:#bb282a\n");
      out.write("}.input-group-addon{\n");
      out.write("  background-color: #fcfcfc;\n");
      out.write("  border: 1px solid #dbdbdb;\n");
      out.write("  border-radius: 0;\n");
      out.write("}\n");
      out.write("input[type=file]{\n");
      out.write("  text-indent: -99999px;\n");
      out.write("}td img.img-thumbnail{\n");
      out.write("  width: 125px;\n");
      out.write("  height: 125px;\n");
      out.write("  vertical-align: top;\n");
      out.write("}.img-avatar{\n");
      out.write("  width: 50px;\n");
      out.write("  height: 50px;\n");
      out.write("}\n");
      out.write(".jumbotron{\n");
      out.write("  margin-bottom: 0;\n");
      out.write("}.list-group-item:first-child,.list-group-item:last-child{\n");
      out.write("  border-radius: 0;\n");
      out.write("}.profile .jumbotron{\n");
      out.write("  border-radius: 3px 3px 0 0;\n");
      out.write("}.profile .jumbotron h3{\n");
      out.write("  color: white;\n");
      out.write("}img.img-size-2{\n");
      out.write("  width: 125px;\n");
      out.write("  height: 125px;\n");
      out.write("}\n");
      out.write("#profile{\n");
      out.write("object-fit:cover;\n");
      out.write("}\n");
      out.write("    \n");
      out.write("    </style>\n");
      out.write("  </head>\n");
      out.write("<header id=\"header\">\n");
      out.write("      <div class=\"logo pull-left\"><img height=40px width =40px style=\"object-fit:cover;transform:translateX(-30px);\"src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/src/icon.png\">Track-Stock</div>\n");
      out.write("      <div class=\"header-content\">\n");
      out.write("      <div class=\"header-date pull-left\">\n");
      out.write("       <strong id=\"current-date-time\"></strong>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"pull-right clearfix\">\n");
      out.write("        <ul class=\"info-menu list-inline list-unstyled\">\n");
      out.write("          <li class=\"profile\">\n");
      out.write("            <a href=\"#\" data-toggle=\"dropdown\" class=\"toggle\" aria-expanded=\"false\">\n");
      out.write("              <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/src/profile.png\" alt=\"user-image\" class=\"img-circle img-inline\">\n");
      out.write("              <span>Venura jayasingha <i class=\"caret\"></i></span>\n");
      out.write("            </a>\n");
      out.write("            <ul class=\"dropdown-menu\">\n");
      out.write("              <li>\n");
      out.write("                  <a href=\"profile.php?id=1\">\n");
      out.write("                      <i class=\"glyphicon glyphicon-user\"></i>\n");
      out.write("                      Profile\n");
      out.write("                  </a>\n");
      out.write("              </li>\n");
      out.write("             <li>\n");
      out.write("                 <a href=\"edit_account.php\" title=\"edit account\">\n");
      out.write("                     <i class=\"glyphicon glyphicon-cog\"></i>\n");
      out.write("                     Settings\n");
      out.write("                 </a>\n");
      out.write("             </li>\n");
      out.write("             <li class=\"last\">\n");
      out.write("                 <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout\">\n");
      out.write("                     <i class=\"glyphicon glyphicon-off\"></i>\n");
      out.write("                     Logout\n");
      out.write("                 </a>\n");
      out.write("             </li>\n");
      out.write("           </ul>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("     </div>\n");
      out.write("    </header>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("              <!-- admin menu -->\n");
      out.write("      <ul>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DashboardDataFetch\">\n");
      out.write("      <i class=\"glyphicon glyphicon-home\"></i>\n");
      out.write("      <span>Dashboard</span>\n");
      out.write("    </a>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"#\" class=\"submenu-toggle\">\n");
      out.write("      <i class=\"glyphicon glyphicon-user\"></i>\n");
      out.write("      <span>User Management</span>\n");
      out.write("    </a>\n");
      out.write("    <ul class=\"nav submenu\" style=\"display: none;\">\n");
      out.write("      <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Admin/UserManagement/UserManagement.jsp\">Manage User Access</a> </li>\n");
      out.write("      <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Admin/UserManagement/Userdetails.jsp\">User Permission</a> </li>\n");
      out.write("   </ul>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Admin/Category/category.jsp\">\n");
      out.write("      <i class=\"glyphicon glyphicon-indent-left\"></i>\n");
      out.write("      <span>Categories</span>\n");
      out.write("    </a>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"#\" class=\"submenu-toggle\">\n");
      out.write("      <i class=\"glyphicon glyphicon-th-large\"></i>\n");
      out.write("      <span>Products</span>\n");
      out.write("    </a>\n");
      out.write("    <ul class=\"nav submenu\" style=\"display: none;\">\n");
      out.write("       <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Admin/Products/Manageproducts.jsp\">Manage Products</a> </li>\n");
      out.write("       <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Admin/Products/Addproduct.jsp\">Add Products</a> </li>\n");
      out.write("   </ul>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"media.php\">\n");
      out.write("      <i class=\"glyphicon glyphicon-picture\"></i>\n");
      out.write("      <span>Media Files</span>\n");
      out.write("    </a>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"#\" class=\"submenu-toggle\">\n");
      out.write("      <i class=\"glyphicon glyphicon-credit-card\"></i>\n");
      out.write("       <span>Sales</span>\n");
      out.write("      </a>\n");
      out.write("      <ul class=\"nav submenu\" style=\"display: none;\">\n");
      out.write("         <li><a href=\"sales.php\">Manage Sales</a> </li>\n");
      out.write("         <li><a href=\"add_sale.php\">Add Sale</a> </li>\n");
      out.write("     </ul>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"#\" class=\"submenu-toggle\">\n");
      out.write("      <i class=\"glyphicon glyphicon-duplicate\"></i>\n");
      out.write("       <span>Sales Report</span>\n");
      out.write("      </a>\n");
      out.write("      <ul class=\"nav submenu\" style=\"display:none;\">\n");
      out.write("        <li><a href=\"sales_report.php\">Sales by dates </a></li>\n");
      out.write("        <li><a href=\"monthly_sales.php\">Monthly sales</a></li>\n");
      out.write("        <li><a href=\"daily_sales.php\">Daily sales</a> </li>\n");
      out.write("      </ul>\n");
      out.write("  </li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("  <script>\n");
      out.write("\n");
      out.write("  function suggetion() {\n");
      out.write("\n");
      out.write("       $('#sug_input').keyup(function(e) {\n");
      out.write("\n");
      out.write("           var formData = {\n");
      out.write("               'product_name' : $('input[name=title]').val()\n");
      out.write("           };\n");
      out.write("\n");
      out.write("           if(formData['product_name'].length >= 1){\n");
      out.write("\n");
      out.write("             // process the form\n");
      out.write("             $.ajax({\n");
      out.write("                 type        : 'POST',\n");
      out.write("                 url         : 'ajax.php',\n");
      out.write("                 data        : formData,\n");
      out.write("                 dataType    : 'json',\n");
      out.write("                 encode      : true\n");
      out.write("             })\n");
      out.write("                 .done(function(data) {\n");
      out.write("                     //console.log(data);\n");
      out.write("                     $('#result').html(data).fadeIn();\n");
      out.write("                     $('#result li').click(function() {\n");
      out.write("\n");
      out.write("                       $('#sug_input').val($(this).text());\n");
      out.write("                       $('#result').fadeOut(500);\n");
      out.write("\n");
      out.write("                     });\n");
      out.write("\n");
      out.write("                     $(\"#sug_input\").blur(function(){\n");
      out.write("                       $(\"#result\").fadeOut(500);\n");
      out.write("                     });\n");
      out.write("\n");
      out.write("                 });\n");
      out.write("\n");
      out.write("           } else {\n");
      out.write("\n");
      out.write("             $(\"#result\").hide();\n");
      out.write("\n");
      out.write("           };\n");
      out.write("\n");
      out.write("           e.preventDefault();\n");
      out.write("       });\n");
      out.write("\n");
      out.write("   }\n");
      out.write("    $('#sug-form').submit(function(e) {\n");
      out.write("        var formData = {\n");
      out.write("            'p_name' : $('input[name=title]').val()\n");
      out.write("        };\n");
      out.write("          // process the form\n");
      out.write("          $.ajax({\n");
      out.write("              type        : 'POST',\n");
      out.write("              url         : 'ajax.php',\n");
      out.write("              data        : formData,\n");
      out.write("              dataType    : 'json',\n");
      out.write("              encode      : true\n");
      out.write("          })\n");
      out.write("              .done(function(data) {\n");
      out.write("                  //console.log(data);\n");
      out.write("                  $('#product_info').html(data).show();\n");
      out.write("                  total();\n");
      out.write("                  $('.datePicker').datepicker('update', new Date());\n");
      out.write("\n");
      out.write("              }).fail(function() {\n");
      out.write("                  $('#product_info').html(data).show();\n");
      out.write("              });\n");
      out.write("        e.preventDefault();\n");
      out.write("    });\n");
      out.write("    function total(){\n");
      out.write("      $('#product_info input').change(function(e)  {\n");
      out.write("              var price = +$('input[name=price]').val() || 0;\n");
      out.write("              var qty   = +$('input[name=quantity]').val() || 0;\n");
      out.write("              var total = qty * price ;\n");
      out.write("                  $('input[name=total]').val(total.toFixed(2));\n");
      out.write("      });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    $(document).ready(function() {\n");
      out.write("\n");
      out.write("      //tooltip\n");
      out.write("      $('[data-toggle=\"tooltip\"]').tooltip();\n");
      out.write("\n");
      out.write("      $('.submenu-toggle').click(function () {\n");
      out.write("         $(this).parent().children('ul.submenu').toggle(200);\n");
      out.write("      });\n");
      out.write("      //suggetion for finding product names\n");
      out.write("      suggetion();\n");
      out.write("      // Callculate total ammont\n");
      out.write("      total();\n");
      out.write("\n");
      out.write("      $('.datepicker')\n");
      out.write("          .datepicker({\n");
      out.write("              format: 'yyyy-mm-dd',\n");
      out.write("              todayHighlight: true,\n");
      out.write("              autoclose: true\n");
      out.write("          });\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("  </script>\n");
      out.write("  \n");
      out.write("  <!--This Displays the Time and Date Dynamically-->\n");
      out.write("  <script>\n");
      out.write("  function updateDateTime() {\n");
      out.write("	    const dateElement = document.querySelector('.header-date strong');\n");
      out.write("	    const now = new Date();\n");
      out.write("	    const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric' };\n");
      out.write("	    const formattedDate = now.toLocaleDateString('en-US', options);\n");
      out.write("	    dateElement.textContent = formattedDate;\n");
      out.write("	}\n");
      out.write("	setInterval(updateDateTime, 1000);\n");
      out.write("	updateDateTime();\n");
      out.write("  </script>\n");
      out.write(" \n");
      out.write("  \n");
      out.write("  </html>    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String id = request.getParameter("id");
    String email = "";
    String access = "";
    String state = "";

    try (Connection conn = DbConn.getConnection();
         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM registered_user WHERE User_ID = ?")) {
        
        pstmt.setString(1, id);  
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                email = rs.getString("email");
                access = rs.getString("Access_level");
                state = rs.getString("Access_state");
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Track-Stock - Edit Access</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"page\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"login-page\">\r\n");
      out.write("      <div class=\"text-center\">\r\n");
      out.write("         <h3>Edit Group</h3>\r\n");
      out.write("      </div>\r\n");
      out.write("      <form method=\"post\" action=\"../../editaccess?id=");
      out.print(id );
      out.write("\" class=\"clearfix\">\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("          <label for=\"name\" class=\"control-label\">Group Name</label>\r\n");
      out.write("          <input type=\"text\" class=\"form-control\" style=\"pointer-events:none\" name=\"email\" value=\"");
      out.print( email != null ? email : "N/A" );
      out.write("\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("          <label for=\"access\">Access Level</label>\r\n");
      out.write("          <select class=\"form-control\" name=\"access_level\">\r\n");
      out.write("            <option value=\"1\" ");
      out.print( "1".equals(access) ? "selected" : "" );
      out.write(">Admin</option>\r\n");
      out.write("            <option value=\"2\" ");
      out.print( "2".equals(access) ? "selected" : "" );
      out.write(">Special</option>\r\n");
      out.write("            <option value=\"3\" ");
      out.print( "3".equals(access) ? "selected" : "" );
      out.write(">User</option>\r\n");
      out.write("          </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("          <label for=\"status\">Status</label>\r\n");
      out.write("          <select class=\"form-control\" name=\"status\">\r\n");
      out.write("            <option value=\"Active\" ");
      out.print( "Active".equals(state) ? "selected" : "" );
      out.write(">Active</option>\r\n");
      out.write("            <option value=\"Deactive\" ");
      out.print( "Deactive".equals(state) ? "selected" : "" );
      out.write(">Deactive</option>\r\n");
      out.write("          </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group clearfix\">\r\n");
      out.write("          <button type=\"submit\" name=\"update\" class=\"btn btn-info\">Update</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
