package com.dianziq.ios;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BulletinBoard {

	public interface Iface {

		public void add(Message msg) throws org.apache.thrift.TException;

		public List<Message> get() throws org.apache.thrift.TException;

	}

	public interface AsyncIface {

		public void add(
				Message msg,
				org.apache.thrift.async.AsyncMethodCallback<AsyncClient.add_call> resultHandler)
				throws org.apache.thrift.TException;

		public void get(
				org.apache.thrift.async.AsyncMethodCallback<AsyncClient.get_call> resultHandler)
				throws org.apache.thrift.TException;

	}

	public static class Client extends org.apache.thrift.TServiceClient
			implements Iface {
		public static class Factory implements
				org.apache.thrift.TServiceClientFactory<Client> {
			public Factory() {
			}

			public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
				return new Client(prot);
			}

			public Client getClient(org.apache.thrift.protocol.TProtocol iprot,
					org.apache.thrift.protocol.TProtocol oprot) {
				return new Client(iprot, oprot);
			}
		}

		public Client(org.apache.thrift.protocol.TProtocol prot) {
			super(prot, prot);
		}

		public Client(org.apache.thrift.protocol.TProtocol iprot,
				org.apache.thrift.protocol.TProtocol oprot) {
			super(iprot, oprot);
		}

		public void add(Message msg) throws org.apache.thrift.TException {
			send_add(msg);
			recv_add();
		}

		public void send_add(Message msg) throws org.apache.thrift.TException {
			add_args args = new add_args();
			args.setMsg(msg);
			sendBase("add", args);
		}

		public void recv_add() throws org.apache.thrift.TException {
			add_result result = new add_result();
			receiveBase(result, "add");
			return;
		}

		public List<Message> get() throws org.apache.thrift.TException {
			send_get();
			return recv_get();
		}

		public void send_get() throws org.apache.thrift.TException {
			get_args args = new get_args();
			sendBase("get", args);
		}

		public List<Message> recv_get() throws org.apache.thrift.TException {
			get_result result = new get_result();
			receiveBase(result, "get");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(
					org.apache.thrift.TApplicationException.MISSING_RESULT,
					"get failed: unknown result");
		}

	}

	public static class AsyncClient extends
			org.apache.thrift.async.TAsyncClient implements AsyncIface {
		public static class Factory implements
				org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
			private org.apache.thrift.async.TAsyncClientManager clientManager;
			private org.apache.thrift.protocol.TProtocolFactory protocolFactory;

			public Factory(
					org.apache.thrift.async.TAsyncClientManager clientManager,
					org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
				this.clientManager = clientManager;
				this.protocolFactory = protocolFactory;
			}

			public AsyncClient getAsyncClient(
					org.apache.thrift.transport.TNonblockingTransport transport) {
				return new AsyncClient(protocolFactory, clientManager,
						transport);
			}
		}

		public AsyncClient(
				org.apache.thrift.protocol.TProtocolFactory protocolFactory,
				org.apache.thrift.async.TAsyncClientManager clientManager,
				org.apache.thrift.transport.TNonblockingTransport transport) {
			super(protocolFactory, clientManager, transport);
		}

		public void add(
				Message msg,
				org.apache.thrift.async.AsyncMethodCallback<add_call> resultHandler)
				throws org.apache.thrift.TException {
			checkReady();
			add_call method_call = new add_call(msg, resultHandler, this,
					___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class add_call extends
				org.apache.thrift.async.TAsyncMethodCall {
			private Message msg;

			public add_call(
					Message msg,
					org.apache.thrift.async.AsyncMethodCallback<add_call> resultHandler,
					org.apache.thrift.async.TAsyncClient client,
					org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport)
					throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
				this.msg = msg;
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot)
					throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage(
						"add", org.apache.thrift.protocol.TMessageType.CALL, 0));
				add_args args = new add_args();
				args.setMsg(msg);
				args.write(prot);
				prot.writeMessageEnd();
			}

			public void getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
						getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client
						.getProtocolFactory().getProtocol(memoryTransport);
				(new Client(prot)).recv_add();
			}
		}

		public void get(
				org.apache.thrift.async.AsyncMethodCallback<get_call> resultHandler)
				throws org.apache.thrift.TException {
			checkReady();
			get_call method_call = new get_call(resultHandler, this,
					___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class get_call extends
				org.apache.thrift.async.TAsyncMethodCall {
			public get_call(
					org.apache.thrift.async.AsyncMethodCallback<get_call> resultHandler,
					org.apache.thrift.async.TAsyncClient client,
					org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport)
					throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot)
					throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage(
						"get", org.apache.thrift.protocol.TMessageType.CALL, 0));
				get_args args = new get_args();
				args.write(prot);
				prot.writeMessageEnd();
			}

			public List<Message> getResult()
					throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
						getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client
						.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_get();
			}
		}

	}

	public static class Processor<I extends Iface> extends
			org.apache.thrift.TBaseProcessor<I> implements
			org.apache.thrift.TProcessor {
		private static final Logger LOGGER = LoggerFactory
				.getLogger(Processor.class.getName());

		public Processor(I iface) {
			super(
					iface,
					getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
		}

		protected Processor(
				I iface,
				Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
			super(iface, getProcessMap(processMap));
		}

		private static <I extends Iface> Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(
				Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
			processMap.put("add", new add());
			processMap.put("get", new get());
			return processMap;
		}

		public static class add<I extends Iface> extends
				org.apache.thrift.ProcessFunction<I, add_args> {
			public add() {
				super("add");
			}

			public add_args getEmptyArgsInstance() {
				return new add_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public add_result getResult(I iface, add_args args)
					throws org.apache.thrift.TException {
				add_result result = new add_result();
				iface.add(args.msg);
				return result;
			}
		}

		public static class get<I extends Iface> extends
				org.apache.thrift.ProcessFunction<I, get_args> {
			public get() {
				super("get");
			}

			public get_args getEmptyArgsInstance() {
				return new get_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public get_result getResult(I iface, get_args args)
					throws org.apache.thrift.TException {
				get_result result = new get_result();
				result.success = iface.get();
				return result;
			}
		}

	}

	public static class add_args implements
			org.apache.thrift.TBase<add_args, add_args._Fields>,
			java.io.Serializable, Cloneable {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
				"add_args");

		private static final org.apache.thrift.protocol.TField MSG_FIELD_DESC = new org.apache.thrift.protocol.TField(
				"msg", org.apache.thrift.protocol.TType.STRUCT, (short) 1);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class,
					new add_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new add_argsTupleSchemeFactory());
		}

		public Message msg; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			MSG((short) 1, "msg");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 1: // MSG
					return MSG;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId
							+ " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
					_Fields.class);
			tmpMap.put(_Fields.MSG,
					new org.apache.thrift.meta_data.FieldMetaData("msg",
							org.apache.thrift.TFieldRequirementType.DEFAULT,
							new org.apache.thrift.meta_data.StructMetaData(
									org.apache.thrift.protocol.TType.STRUCT,
									Message.class)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
					add_args.class, metaDataMap);
		}

		public add_args() {
		}

		public add_args(Message msg) {
			this();
			this.msg = msg;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public add_args(add_args other) {
			if (other.isSetMsg()) {
				this.msg = new Message(other.msg);
			}
		}

		public add_args deepCopy() {
			return new add_args(this);
		}

		@Override
		public void clear() {
			this.msg = null;
		}

		public Message getMsg() {
			return this.msg;
		}

		public add_args setMsg(Message msg) {
			this.msg = msg;
			return this;
		}

		public void unsetMsg() {
			this.msg = null;
		}

		/**
		 * Returns true if field msg is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetMsg() {
			return this.msg != null;
		}

		public void setMsgIsSet(boolean value) {
			if (!value) {
				this.msg = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case MSG:
				if (value == null) {
					unsetMsg();
				} else {
					setMsg((Message) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case MSG:
				return getMsg();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case MSG:
				return isSetMsg();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof add_args)
				return this.equals((add_args) that);
			return false;
		}

		public boolean equals(add_args that) {
			if (that == null)
				return false;

			boolean this_present_msg = true && this.isSetMsg();
			boolean that_present_msg = true && that.isSetMsg();
			if (this_present_msg || that_present_msg) {
				if (!(this_present_msg && that_present_msg))
					return false;
				if (!this.msg.equals(that.msg))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		public int compareTo(add_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(
						other.getClass().getName());
			}

			int lastComparison = 0;
			add_args typedOther = (add_args) other;

			lastComparison = Boolean.valueOf(isSetMsg()).compareTo(
					typedOther.isSetMsg());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetMsg()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(
						this.msg, typedOther.msg);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot)
				throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot)
				throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("add_args(");
			boolean first = true;

			sb.append("msg:");
			if (this.msg == null) {
				sb.append("null");
			} else {
				sb.append(this.msg);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
			if (msg != null) {
				msg.validate();
			}
		}

		private void writeObject(java.io.ObjectOutputStream out)
				throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in)
				throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class add_argsStandardSchemeFactory implements
				SchemeFactory {
			public add_argsStandardScheme getScheme() {
				return new add_argsStandardScheme();
			}
		}

		private static class add_argsStandardScheme extends
				StandardScheme<add_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot,
					add_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 1: // MSG
						if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
							struct.msg = new Message();
							struct.msg.read(iprot);
							struct.setMsgIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(
									iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
								schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot,
					add_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.msg != null) {
					oprot.writeFieldBegin(MSG_FIELD_DESC);
					struct.msg.write(oprot);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class add_argsTupleSchemeFactory implements
				SchemeFactory {
			public add_argsTupleScheme getScheme() {
				return new add_argsTupleScheme();
			}
		}

		private static class add_argsTupleScheme extends TupleScheme<add_args> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot,
					add_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetMsg()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetMsg()) {
					struct.msg.write(oprot);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot,
					add_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.msg = new Message();
					struct.msg.read(iprot);
					struct.setMsgIsSet(true);
				}
			}
		}

	}

	public static class add_result implements
			org.apache.thrift.TBase<add_result, add_result._Fields>,
			java.io.Serializable, Cloneable {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
				"add_result");

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class,
					new add_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new add_resultTupleSchemeFactory());
		}

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			;

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId
							+ " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
					_Fields.class);
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
					add_result.class, metaDataMap);
		}

		public add_result() {
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public add_result(add_result other) {
		}

		public add_result deepCopy() {
			return new add_result(this);
		}

		@Override
		public void clear() {
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof add_result)
				return this.equals((add_result) that);
			return false;
		}

		public boolean equals(add_result that) {
			if (that == null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		public int compareTo(add_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(
						other.getClass().getName());
			}

			int lastComparison = 0;
			add_result typedOther = (add_result) other;

			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot)
				throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot)
				throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("add_result(");
			boolean first = true;

			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out)
				throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in)
				throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class add_resultStandardSchemeFactory implements
				SchemeFactory {
			public add_resultStandardScheme getScheme() {
				return new add_resultStandardScheme();
			}
		}

		private static class add_resultStandardScheme extends
				StandardScheme<add_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot,
					add_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
								schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot,
					add_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class add_resultTupleSchemeFactory implements
				SchemeFactory {
			public add_resultTupleScheme getScheme() {
				return new add_resultTupleScheme();
			}
		}

		private static class add_resultTupleScheme extends
				TupleScheme<add_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot,
					add_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot,
					add_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
			}
		}

	}

	public static class get_args implements
			org.apache.thrift.TBase<get_args, get_args._Fields>,
			java.io.Serializable, Cloneable {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
				"get_args");

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class,
					new get_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new get_argsTupleSchemeFactory());
		}

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			;

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId
							+ " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
					_Fields.class);
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
					get_args.class, metaDataMap);
		}

		public get_args() {
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public get_args(get_args other) {
		}

		public get_args deepCopy() {
			return new get_args(this);
		}

		@Override
		public void clear() {
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof get_args)
				return this.equals((get_args) that);
			return false;
		}

		public boolean equals(get_args that) {
			if (that == null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		public int compareTo(get_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(
						other.getClass().getName());
			}

			int lastComparison = 0;
			get_args typedOther = (get_args) other;

			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot)
				throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot)
				throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("get_args(");
			boolean first = true;

			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out)
				throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in)
				throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class get_argsStandardSchemeFactory implements
				SchemeFactory {
			public get_argsStandardScheme getScheme() {
				return new get_argsStandardScheme();
			}
		}

		private static class get_argsStandardScheme extends
				StandardScheme<get_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot,
					get_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
								schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot,
					get_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class get_argsTupleSchemeFactory implements
				SchemeFactory {
			public get_argsTupleScheme getScheme() {
				return new get_argsTupleScheme();
			}
		}

		private static class get_argsTupleScheme extends TupleScheme<get_args> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot,
					get_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot,
					get_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
			}
		}

	}

	public static class get_result implements
			org.apache.thrift.TBase<get_result, get_result._Fields>,
			java.io.Serializable, Cloneable {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
				"get_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
				"success", org.apache.thrift.protocol.TType.LIST, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class,
					new get_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new get_resultTupleSchemeFactory());
		}

		public List<Message> success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId
							+ " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
					_Fields.class);
			tmpMap.put(
					_Fields.SUCCESS,
					new org.apache.thrift.meta_data.FieldMetaData(
							"success",
							org.apache.thrift.TFieldRequirementType.DEFAULT,
							new org.apache.thrift.meta_data.ListMetaData(
									org.apache.thrift.protocol.TType.LIST,
									new org.apache.thrift.meta_data.StructMetaData(
											org.apache.thrift.protocol.TType.STRUCT,
											Message.class))));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
					get_result.class, metaDataMap);
		}

		public get_result() {
		}

		public get_result(List<Message> success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public get_result(get_result other) {
			if (other.isSetSuccess()) {
				List<Message> __this__success = new ArrayList<Message>();
				for (Message other_element : other.success) {
					__this__success.add(new Message(other_element));
				}
				this.success = __this__success;
			}
		}

		public get_result deepCopy() {
			return new get_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public int getSuccessSize() {
			return (this.success == null) ? 0 : this.success.size();
		}

		public java.util.Iterator<Message> getSuccessIterator() {
			return (this.success == null) ? null : this.success.iterator();
		}

		public void addToSuccess(Message elem) {
			if (this.success == null) {
				this.success = new ArrayList<Message>();
			}
			this.success.add(elem);
		}

		public List<Message> getSuccess() {
			return this.success;
		}

		public get_result setSuccess(List<Message> success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((List<Message>) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof get_result)
				return this.equals((get_result) that);
			return false;
		}

		public boolean equals(get_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		public int compareTo(get_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(
						other.getClass().getName());
			}

			int lastComparison = 0;
			get_result typedOther = (get_result) other;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(
					typedOther.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(
						this.success, typedOther.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot)
				throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot)
				throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("get_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out)
				throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in)
				throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(
						new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class get_resultStandardSchemeFactory implements
				SchemeFactory {
			public get_resultStandardScheme getScheme() {
				return new get_resultStandardScheme();
			}
		}

		private static class get_resultStandardScheme extends
				StandardScheme<get_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot,
					get_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
							{
								org.apache.thrift.protocol.TList _list0 = iprot
										.readListBegin();
								struct.success = new ArrayList<Message>(
										_list0.size);
								for (int _i1 = 0; _i1 < _list0.size; ++_i1) {
									Message _elem2; // required
									_elem2 = new Message();
									_elem2.read(iprot);
									struct.success.add(_elem2);
								}
								iprot.readListEnd();
							}
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(
									iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
								schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot,
					get_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					{
						oprot.writeListBegin(new org.apache.thrift.protocol.TList(
								org.apache.thrift.protocol.TType.STRUCT,
								struct.success.size()));
						for (Message _iter3 : struct.success) {
							_iter3.write(oprot);
						}
						oprot.writeListEnd();
					}
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class get_resultTupleSchemeFactory implements
				SchemeFactory {
			public get_resultTupleScheme getScheme() {
				return new get_resultTupleScheme();
			}
		}

		private static class get_resultTupleScheme extends
				TupleScheme<get_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot,
					get_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					{
						oprot.writeI32(struct.success.size());
						for (Message _iter4 : struct.success) {
							_iter4.write(oprot);
						}
					}
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot,
					get_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					{
						org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(
								org.apache.thrift.protocol.TType.STRUCT,
								iprot.readI32());
						struct.success = new ArrayList<Message>(_list5.size);
						for (int _i6 = 0; _i6 < _list5.size; ++_i6) {
							Message _elem7; // required
							_elem7 = new Message();
							_elem7.read(iprot);
							struct.success.add(_elem7);
						}
					}
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

}
