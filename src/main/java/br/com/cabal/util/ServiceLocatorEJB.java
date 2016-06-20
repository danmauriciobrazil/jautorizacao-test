package br.com.cabal.util;

import java.util.Properties;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocatorEJB {

	public static String conexao;
	private Context context;
	private static ServiceLocatorEJB serviceLocatorEJB;

	public ServiceLocatorEJB() {
	}

	public static ServiceLocatorEJB getInstance() {
		if (serviceLocatorEJB == null) {
			serviceLocatorEJB = new ServiceLocatorEJB();
		}
		return serviceLocatorEJB;
	}

	public Object getEjbObject(final String name) throws NamingException {
		try {
			initContext();
			if (this.context == null) {
				if (this.context == null) {
					throw new CommunicationException("Objeto remoto indisponível");
				}
			}
			return this.context.lookup("jautorizacao-ear/" + name + "/remote");//"jautorizacao-ear/" + name + "/remote");
//			resetAtcServiceImpl
		} catch (final Throwable e) {
			throw new CommunicationException("Objeto remoto indisponível"+ name);
		}
	}

	private void initContext() {
		try {
			
			final Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");

			
			properties.put(Context.PROVIDER_URL, "jnp://192.168.5.250:1299");
			//properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		
			this.context = new InitialContext(properties);

		} catch (final Throwable t) {
			t.printStackTrace();
		}
	}

}
