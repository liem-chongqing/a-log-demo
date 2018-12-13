package com.uwang.mail.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liem.mail.MailModel;
import com.liem.mail.MailTo;



@WebServlet("/sendmail")
public class EmailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 得到MailModel对象
		MailModel mailModel = MailModel.getInstance("mxail.properties");
		// 设置收件人
		mailModel.setToAddress("996052600@qq.com");
		// 设置邮件标题
		mailModel.setSubject("中国好声音一等奖验证");
		// 设置邮件内容
		String code ="666666";
		mailModel.setContent("您正在进行中国好声音一等奖验证，验证码为：" + code);
		//  这个类主要来发送邮件
		Boolean result = MailTo.sendEmail(mailModel, MailTo.SEND_TEXT);
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(result) {
			HttpSession session = req.getSession();
			session.setAttribute("mailCode", code);
			out.write("发送成功，请前往你的邮箱查看！");
		}else {
			out.write("发送失败！");
		}
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		
		// 得到MailModel对象
		MailModel mailModel = MailModel.getInstance("mxail.properties");
		// 设置收件人
		mailModel.setToAddress("996052600@qq.com");
		// 设置邮件标题
		mailModel.setSubject("中国好声音一等奖验证");
		// 设置邮件内容
		String code ="666666";
		mailModel.setContent("您正在进行中国好声音一等奖验证，验证码为：" + code);
		//  这个类主要来发送邮件
		Boolean result = MailTo.sendEmail(mailModel, MailTo.SEND_TEXT);
	}
}
