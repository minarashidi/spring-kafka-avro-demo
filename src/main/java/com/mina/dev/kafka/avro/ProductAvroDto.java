package com.mina.dev.kafka.avro; /**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ProductAvroDto extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4221096748512269346L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ProductAvroDto\",\"fields\":[{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"price\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"currency\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"category\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"subCategory\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"createdAt\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"updatedAt\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ProductAvroDto> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ProductAvroDto> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ProductAvroDto> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ProductAvroDto> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ProductAvroDto> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ProductAvroDto to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ProductAvroDto from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ProductAvroDto instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ProductAvroDto fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence name;
  private java.lang.Double price;
  private java.lang.CharSequence currency;
  private java.lang.CharSequence category;
  private java.lang.CharSequence subCategory;
  private java.lang.CharSequence createdAt;
  private java.lang.CharSequence updatedAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ProductAvroDto() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param price The new value for price
   * @param currency The new value for currency
   * @param category The new value for category
   * @param subCategory The new value for subCategory
   * @param createdAt The new value for createdAt
   * @param updatedAt The new value for updatedAt
   */
  public ProductAvroDto(java.lang.CharSequence id, java.lang.CharSequence name, java.lang.Double price, java.lang.CharSequence currency, java.lang.CharSequence category, java.lang.CharSequence subCategory, java.lang.CharSequence createdAt, java.lang.CharSequence updatedAt) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.currency = currency;
    this.category = category;
    this.subCategory = subCategory;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return price;
    case 3: return currency;
    case 4: return category;
    case 5: return subCategory;
    case 6: return createdAt;
    case 7: return updatedAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: price = (java.lang.Double)value$; break;
    case 3: currency = (java.lang.CharSequence)value$; break;
    case 4: category = (java.lang.CharSequence)value$; break;
    case 5: subCategory = (java.lang.CharSequence)value$; break;
    case 6: createdAt = (java.lang.CharSequence)value$; break;
    case 7: updatedAt = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.lang.Double getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.lang.Double value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'currency' field.
   * @return The value of the 'currency' field.
   */
  public java.lang.CharSequence getCurrency() {
    return currency;
  }


  /**
   * Sets the value of the 'currency' field.
   * @param value the value to set.
   */
  public void setCurrency(java.lang.CharSequence value) {
    this.currency = value;
  }

  /**
   * Gets the value of the 'category' field.
   * @return The value of the 'category' field.
   */
  public java.lang.CharSequence getCategory() {
    return category;
  }


  /**
   * Sets the value of the 'category' field.
   * @param value the value to set.
   */
  public void setCategory(java.lang.CharSequence value) {
    this.category = value;
  }

  /**
   * Gets the value of the 'subCategory' field.
   * @return The value of the 'subCategory' field.
   */
  public java.lang.CharSequence getSubCategory() {
    return subCategory;
  }


  /**
   * Sets the value of the 'subCategory' field.
   * @param value the value to set.
   */
  public void setSubCategory(java.lang.CharSequence value) {
    this.subCategory = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.lang.CharSequence getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.lang.CharSequence value) {
    this.createdAt = value;
  }

  /**
   * Gets the value of the 'updatedAt' field.
   * @return The value of the 'updatedAt' field.
   */
  public java.lang.CharSequence getUpdatedAt() {
    return updatedAt;
  }


  /**
   * Sets the value of the 'updatedAt' field.
   * @param value the value to set.
   */
  public void setUpdatedAt(java.lang.CharSequence value) {
    this.updatedAt = value;
  }

  /**
   * Creates a new ProductAvroDto RecordBuilder.
   * @return A new ProductAvroDto RecordBuilder
   */
  public static ProductAvroDto.Builder newBuilder() {
    return new ProductAvroDto.Builder();
  }

  /**
   * Creates a new ProductAvroDto RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ProductAvroDto RecordBuilder
   */
  public static ProductAvroDto.Builder newBuilder(ProductAvroDto.Builder other) {
    if (other == null) {
      return new ProductAvroDto.Builder();
    } else {
      return new ProductAvroDto.Builder(other);
    }
  }

  /**
   * Creates a new ProductAvroDto RecordBuilder by copying an existing ProductAvroDto instance.
   * @param other The existing instance to copy.
   * @return A new ProductAvroDto RecordBuilder
   */
  public static ProductAvroDto.Builder newBuilder(ProductAvroDto other) {
    if (other == null) {
      return new ProductAvroDto.Builder();
    } else {
      return new ProductAvroDto.Builder(other);
    }
  }

  /**
   * RecordBuilder for ProductAvroDto instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProductAvroDto>
    implements org.apache.avro.data.RecordBuilder<ProductAvroDto> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence name;
    private java.lang.Double price;
    private java.lang.CharSequence currency;
    private java.lang.CharSequence category;
    private java.lang.CharSequence subCategory;
    private java.lang.CharSequence createdAt;
    private java.lang.CharSequence updatedAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(ProductAvroDto.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.currency)) {
        this.currency = data().deepCopy(fields()[3].schema(), other.currency);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.category)) {
        this.category = data().deepCopy(fields()[4].schema(), other.category);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.subCategory)) {
        this.subCategory = data().deepCopy(fields()[5].schema(), other.subCategory);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[6].schema(), other.createdAt);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.updatedAt)) {
        this.updatedAt = data().deepCopy(fields()[7].schema(), other.updatedAt);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing ProductAvroDto instance
     * @param other The existing instance to copy.
     */
    private Builder(ProductAvroDto other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.currency)) {
        this.currency = data().deepCopy(fields()[3].schema(), other.currency);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.category)) {
        this.category = data().deepCopy(fields()[4].schema(), other.category);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.subCategory)) {
        this.subCategory = data().deepCopy(fields()[5].schema(), other.subCategory);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[6].schema(), other.createdAt);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.updatedAt)) {
        this.updatedAt = data().deepCopy(fields()[7].schema(), other.updatedAt);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.Double getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setPrice(java.lang.Double value) {
      validate(fields()[2], value);
      this.price = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearPrice() {
      price = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'currency' field.
      * @return The value.
      */
    public java.lang.CharSequence getCurrency() {
      return currency;
    }


    /**
      * Sets the value of the 'currency' field.
      * @param value The value of 'currency'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setCurrency(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.currency = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'currency' field has been set.
      * @return True if the 'currency' field has been set, false otherwise.
      */
    public boolean hasCurrency() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'currency' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearCurrency() {
      currency = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'category' field.
      * @return The value.
      */
    public java.lang.CharSequence getCategory() {
      return category;
    }


    /**
      * Sets the value of the 'category' field.
      * @param value The value of 'category'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setCategory(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.category = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'category' field has been set.
      * @return True if the 'category' field has been set, false otherwise.
      */
    public boolean hasCategory() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'category' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearCategory() {
      category = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'subCategory' field.
      * @return The value.
      */
    public java.lang.CharSequence getSubCategory() {
      return subCategory;
    }


    /**
      * Sets the value of the 'subCategory' field.
      * @param value The value of 'subCategory'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setSubCategory(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.subCategory = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'subCategory' field has been set.
      * @return True if the 'subCategory' field has been set, false otherwise.
      */
    public boolean hasSubCategory() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'subCategory' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearSubCategory() {
      subCategory = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.lang.CharSequence getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setCreatedAt(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.createdAt = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearCreatedAt() {
      createdAt = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'updatedAt' field.
      * @return The value.
      */
    public java.lang.CharSequence getUpdatedAt() {
      return updatedAt;
    }


    /**
      * Sets the value of the 'updatedAt' field.
      * @param value The value of 'updatedAt'.
      * @return This builder.
      */
    public ProductAvroDto.Builder setUpdatedAt(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.updatedAt = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'updatedAt' field has been set.
      * @return True if the 'updatedAt' field has been set, false otherwise.
      */
    public boolean hasUpdatedAt() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'updatedAt' field.
      * @return This builder.
      */
    public ProductAvroDto.Builder clearUpdatedAt() {
      updatedAt = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProductAvroDto build() {
      try {
        ProductAvroDto record = new ProductAvroDto();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.price = fieldSetFlags()[2] ? this.price : (java.lang.Double) defaultValue(fields()[2]);
        record.currency = fieldSetFlags()[3] ? this.currency : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.category = fieldSetFlags()[4] ? this.category : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.subCategory = fieldSetFlags()[5] ? this.subCategory : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.createdAt = fieldSetFlags()[6] ? this.createdAt : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.updatedAt = fieldSetFlags()[7] ? this.updatedAt : (java.lang.CharSequence) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ProductAvroDto>
    WRITER$ = (org.apache.avro.io.DatumWriter<ProductAvroDto>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ProductAvroDto>
    READER$ = (org.apache.avro.io.DatumReader<ProductAvroDto>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.id == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.id);
    }

    if (this.name == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.name);
    }

    if (this.price == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeDouble(this.price);
    }

    if (this.currency == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.currency);
    }

    if (this.category == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.category);
    }

    if (this.subCategory == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.subCategory);
    }

    if (this.createdAt == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.createdAt);
    }

    if (this.updatedAt == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.updatedAt);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.id = null;
      } else {
        this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.name = null;
      } else {
        this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.price = null;
      } else {
        this.price = in.readDouble();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.currency = null;
      } else {
        this.currency = in.readString(this.currency instanceof Utf8 ? (Utf8)this.currency : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.category = null;
      } else {
        this.category = in.readString(this.category instanceof Utf8 ? (Utf8)this.category : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.subCategory = null;
      } else {
        this.subCategory = in.readString(this.subCategory instanceof Utf8 ? (Utf8)this.subCategory : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.createdAt = null;
      } else {
        this.createdAt = in.readString(this.createdAt instanceof Utf8 ? (Utf8)this.createdAt : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.updatedAt = null;
      } else {
        this.updatedAt = in.readString(this.updatedAt instanceof Utf8 ? (Utf8)this.updatedAt : null);
      }

    } else {
      for (int i = 0; i < 8; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.id = null;
          } else {
            this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.name = null;
          } else {
            this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.price = null;
          } else {
            this.price = in.readDouble();
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.currency = null;
          } else {
            this.currency = in.readString(this.currency instanceof Utf8 ? (Utf8)this.currency : null);
          }
          break;

        case 4:
          if (in.readIndex() != 1) {
            in.readNull();
            this.category = null;
          } else {
            this.category = in.readString(this.category instanceof Utf8 ? (Utf8)this.category : null);
          }
          break;

        case 5:
          if (in.readIndex() != 1) {
            in.readNull();
            this.subCategory = null;
          } else {
            this.subCategory = in.readString(this.subCategory instanceof Utf8 ? (Utf8)this.subCategory : null);
          }
          break;

        case 6:
          if (in.readIndex() != 1) {
            in.readNull();
            this.createdAt = null;
          } else {
            this.createdAt = in.readString(this.createdAt instanceof Utf8 ? (Utf8)this.createdAt : null);
          }
          break;

        case 7:
          if (in.readIndex() != 1) {
            in.readNull();
            this.updatedAt = null;
          } else {
            this.updatedAt = in.readString(this.updatedAt instanceof Utf8 ? (Utf8)this.updatedAt : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









