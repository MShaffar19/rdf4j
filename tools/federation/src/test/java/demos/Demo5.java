/*******************************************************************************
 * Copyright (c) 2019 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package demos;

import java.util.Arrays;

import org.eclipse.rdf4j.federated.Config;
import org.eclipse.rdf4j.federated.FedXFactory;
import org.eclipse.rdf4j.federated.QueryManager;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;

public class Demo5
{

	public static void main(String[] args) throws Exception
	{

		Config.initialize();
		Repository repo = FedXFactory.initializeSparqlFederation(Arrays.asList(
				"http://dbpedia.org/sparql",
				"http://data.semanticweb.org/sparql"));

		String q = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\n"
				+ "SELECT ?President ?Party WHERE {\n"
				+ "?President rdf:type dbpedia-owl:President .\n"
				+ "?President dbpedia-owl:party ?Party . }";

		TupleQuery query = QueryManager.prepareTupleQuery(q);
		try (TupleQueryResult res = query.evaluate()) {

			while (res.hasNext()) {
				System.out.println(res.next());
			}
		}

		repo.shutDown();
		System.out.println("Done.");
		System.exit(0);

	}
}