package com.guzichenko.templates.fix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;

import quickfix.Acceptor;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RejectLogon;
import quickfix.ScreenLogFactory;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.UnsupportedMessageType;

public class Server extends MessageCracker implements Application {

	@Override
	public void onCreate(SessionID sessionID) {
	}

	@Override
	public void onLogon(SessionID sessionID) {
	}

	@Override
	public void onLogout(SessionID sessionID) {
	}

	@Override
	public void toAdmin(Message message, SessionID sessionID) {
	}

	@Override
	public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
	}

	@Override
	public void toApp(Message message, SessionID sessionID) throws DoNotSend {
	}

	@Override
	public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue,
			UnsupportedMessageType {
		System.out.println("FromApp: " + message);
		crack(message, sessionID);

	}

	@Override
	protected void onMessage(Message message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
		super.onMessage(message, sessionID);
	}

	public static void main(String[] args) throws ConfigError, FileNotFoundException, InterruptedException, SessionNotFound {

		Application application = new Server();
		SessionSettings settings = new SessionSettings(new FileInputStream("FIX/src/main/resources/server.txt"));
		MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
		LogFactory logFactory = new ScreenLogFactory(true, true, true);
		MessageFactory messageFactory = new DefaultMessageFactory();

		Acceptor initiator = new SocketAcceptor(application, messageStoreFactory, settings, logFactory, messageFactory);
		initiator.start();

		CountDownLatch latch = new CountDownLatch(1);
		latch.await();
	}
}