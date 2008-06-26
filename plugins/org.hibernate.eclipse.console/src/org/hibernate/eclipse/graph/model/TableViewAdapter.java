/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.hibernate.eclipse.graph.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;


public class TableViewAdapter extends GraphNode {

	private Table table;
	private final ConfigurationViewAdapter configuration;

	public TableViewAdapter(ConfigurationViewAdapter configuration, Table table) {
		this.configuration = configuration;
		this.table = table;
	}
	
	public void createAssociations() {
		
		
	}

	public Table getTable() {
		return table;
	}

	public List getColumns() {
		List result = new ArrayList();
		Iterator columnIterator = table.getColumnIterator();
		while ( columnIterator.hasNext() ) {
			Column element = (Column) columnIterator.next();
			result.add(new ColumnViewAdapter(this,element));
		}
		
		return result; 
	}

}
