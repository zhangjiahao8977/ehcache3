/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.clustered.server;

import org.terracotta.entity.ActiveInvokeContext;
import org.terracotta.entity.ClientDescriptor;
import org.terracotta.entity.ClientSourceId;
import org.terracotta.entity.InvokeContext;

public final class TestInvokeContext implements ActiveInvokeContext {

  private final ClientDescriptor clientDescriptor = new TestClientDescriptor();

  @Override
  public ClientDescriptor getClientDescriptor() {
    return clientDescriptor;
  }

  @Override
  public ClientSourceId getClientSource() {
    return clientDescriptor.getSourceId();
  }

  @Override
  public long getCurrentTransactionId() {
    return 1;
  }

  @Override
  public long getOldestTransactionId() {
    return 1;
  }

  @Override
  public boolean isValidClientInformation() {
    throw new UnsupportedOperationException("TODO Implement me!");
  }

  @Override
  public ClientSourceId makeClientSourceId(long l) {
    return new TestClientSourceId(l);
  }
}
