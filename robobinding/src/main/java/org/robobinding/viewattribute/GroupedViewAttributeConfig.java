/**
 * Copyright 2013 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute;

import org.robobinding.attribute.PendingGroupAttributes;
import org.robobinding.util.EqualsBuilder;
import org.robobinding.util.HashCodeBuilder;

import android.view.View;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class GroupedViewAttributeConfig<T extends View> extends AbstractViewAttributeConfig<T>
{
	private PendingGroupAttributes pendingGroupAttributes;
	private ViewListenersInjector viewListenersInjector;

	public GroupedViewAttributeConfig(T view, PendingGroupAttributes pendingGroupAttributes, ViewListenersInjector viewListenersInjector)
	{
		super(view);
		this.pendingGroupAttributes = pendingGroupAttributes;
		this.viewListenersInjector = viewListenersInjector;
	}

	public PendingGroupAttributes getPendingGroupAttributes()
	{
		return pendingGroupAttributes;
	}

	public ViewListenersInjector getViewListenersInjector()
	{
		return viewListenersInjector;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (this == other)
			return true;
		if (!(other instanceof GroupedViewAttributeConfig))
			return false;
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final GroupedViewAttributeConfig<T> that = (GroupedViewAttributeConfig) other;
		return new EqualsBuilder()
			.appendSuper(super.equals(that))
			.append(pendingGroupAttributes, that.pendingGroupAttributes)
			.append(viewListenersInjector, that.viewListenersInjector)
			.isEquals();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder()
			.appendSuper(super.hashCode())
			.append(pendingGroupAttributes)
			.append(viewListenersInjector)
			.toHashCode();
	}

}
