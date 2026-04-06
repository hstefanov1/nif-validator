# nif-validator

A lightweight Java utility for validating Portuguese NIF (_Número de Identificação Fiscal_) numbers.

Checks format, digit-only content, and the official check digit algorithm — no external dependencies required.

---

## What is a NIF?

A NIF is a 9-digit Portuguese tax identification number issued to individuals and companies. It follows a specific
structure with a mathematically verifiable check digit.

---

## Project Structure

```
nif-validator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── io/github/hstefanov1/nifvalidator/
│   │           └── NifValidator.java
│   └── test/
│       └── java/
│           └── io/github/hstefanov1/nifvalidator/
│               └── NifValidatorTest.java
├── pom.xml
├── README.md
└── LICENSE
```

---

## Usage

```java
import io.github.hstefanov1.nifvalidator.NifValidator;

NifValidator.isNif("372818281"); // false
NifValidator.isNif("545259045"); // true
```

### Method

```java
public static boolean isNif(String nif)
```

| Parameter | Type     | Description                        |
|-----------|----------|------------------------------------|
| `nif`     | `String` | The 9-digit NIF number to validate |

**Returns** `true` if the NIF is valid, `false` otherwise.

**Handles:**
- `null` input
- Wrong length
- Non-digit characters
- Invalid check digit

---

## Building

```bash
mvn package
```

## Running the Tests

```bash
mvn test
```

---

## Requirements

- Java 17+
- Maven 3.9+

---

## Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

Ideas for contributions:

- **Support for NIF type identification** — NIFs starting with certain digits indicate the type (individual, company,
  public entity, etc.). A method like `getNifType(String nif)` would be a natural extension
- **Spring Boot / Quarkus integration** — a `@ValidNif` annotation for bean validation
- **CLI support** — run validation directly from the terminal

---

## License

MIT — free to use, modify, and distribute.
