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
		// �õ�MailModel����
		MailModel mailModel = MailModel.getInstance("mxail.properties");
		// �����ռ���
		mailModel.setToAddress("996052600@qq.com");
		// �����ʼ�����
		mailModel.setSubject("�й�������һ�Ƚ���֤");
		// �����ʼ�����
		String code ="666666";
		mailModel.setContent("�����ڽ����й�������һ�Ƚ���֤����֤��Ϊ��" + code);
		//  �������Ҫ�������ʼ�
		Boolean result = MailTo.sendEmail(mailModel, MailTo.SEND_TEXT);
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(result) {
			HttpSession session = req.getSession();
			session.setAttribute("mailCode", code);
			out.write("���ͳɹ�����ǰ���������鿴��");
		}else {
			out.write("����ʧ�ܣ�");
		}
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		
		// �õ�MailModel����
		MailModel mailModel = MailModel.getInstance("mxail.properties");
		// �����ռ���
		mailModel.setToAddress("996052600@qq.com");
		// �����ʼ�����
		mailModel.setSubject("�й�������һ�Ƚ���֤");
		// �����ʼ�����
		String code ="666666";
		mailModel.setContent("�����ڽ����й�������һ�Ƚ���֤����֤��Ϊ��" + code);
		//  �������Ҫ�������ʼ�
		Boolean result = MailTo.sendEmail(mailModel, MailTo.SEND_TEXT);
	}
}
