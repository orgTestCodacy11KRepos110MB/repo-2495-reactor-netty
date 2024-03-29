/*
 * Copyright (c) 2018-2021 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.netty.http.client;

import reactor.netty.ConnectionObserver;

/**
 * Specific Http Client state observable by {@link HttpClient#observe(ConnectionObserver)}
 *
 * @author Stephane Maldini
 */
public enum HttpClientState implements ConnectionObserver.State {
	/**
	 * The request has been prepared and ready for I/O handler to be invoked
	 */
	REQUEST_PREPARED() {
		@Override
		public String toString() {
			return "[request_prepared]";
		}
	},
	/**
	 * The request has been sent
	 */
	REQUEST_SENT() {
		@Override
		public String toString() {
			return "[request_sent]";
		}
	},
	/**
	 * The request has been sent but the response has not been fully received and the
	 * connection has been prematurely closed
	 */
	RESPONSE_INCOMPLETE() {
		@Override
		public String toString() {
			return "[response_incomplete]";
		}
	},
	/**
	 * The response status and headers have been received
	 */
	RESPONSE_RECEIVED() {
		@Override
		public String toString() {
			return "[response_received]";
		}
	},
	/**
	 * The response fully received
	 */
	RESPONSE_COMPLETED() {
		@Override
		public String toString() {
			return "[response_completed]";
		}
	},
	/**
	 * Propagated when a stream is bound to a channelOperation and ready for
	 * user interaction
	 */
	STREAM_CONFIGURED() {
		@Override
		public String toString() {
			return "[stream_configured]";
		}
	},
	/**
	 * The H2C upgrade was unsuccessful due to the server not issuing
	 * with a 101 Switching Protocols response. This may indicate that the server
	 * does not support H2C.
	 */
	UPGRADE_REJECTED() {
		@Override
		public String toString() {
			return "[upgrade_rejected]";
		}
	},
	/**
	 * The H2C upgrade was successful.
	 */
	UPGRADE_SUCCESSFUL() {
		@Override
		public String toString() {
			return "[upgrade_successful]";
		}
	}
}
