/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package org.jboss.tools.hibernate.jpt.core.internal.context.orm;

import org.eclipse.jpt.jpa.core.context.orm.OrmManyToOneMapping;
import org.eclipse.jpt.jpa.core.context.orm.OrmSpecifiedJoinColumnRelationshipStrategy;
import org.eclipse.jpt.jpa.core.internal.context.orm.GenericOrmManyToOneRelationship;

/**
 * @author Dmitry Geraskov
 *
 */
public class HibernateOrmManyToOneRelationshipReference extends
		GenericOrmManyToOneRelationship {

	public HibernateOrmManyToOneRelationshipReference(
			OrmManyToOneMapping parent) {
		super(parent);
	}

	@Override
	protected OrmSpecifiedJoinColumnRelationshipStrategy buildJoinColumnStrategy() {
		return new HibernateOrmJoinColumnJoiningStrategy(this);
	}

}
