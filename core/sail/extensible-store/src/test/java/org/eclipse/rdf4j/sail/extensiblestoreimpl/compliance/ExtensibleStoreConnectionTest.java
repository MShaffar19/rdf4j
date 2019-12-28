/*******************************************************************************
 * Copyright (c) 2019 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.sail.extensiblestoreimpl.compliance;

import org.eclipse.rdf4j.IsolationLevels;
import org.eclipse.rdf4j.IsolationLevels;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnectionTest;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.extensiblestoreimpl.ExtensibleStoreImplForTests;
import org.junit.runners.Parameterized;

public class ExtensibleStoreConnectionTest extends RepositoryConnectionTest {

	public ExtensibleStoreConnectionTest(IsolationLevels level) {
		super(level);
	}

	@Parameterized.Parameters(name = "{0}")
	public static IsolationLevels[] parameters() {
		return new IsolationLevels[] {
				IsolationLevels.NONE,
				IsolationLevels.READ_UNCOMMITTED,
				IsolationLevels.READ_COMMITTED
		};
	}

	@Override
	protected Repository createRepository() {
		return new SailRepository(new ExtensibleStoreImplForTests());
	}

}
