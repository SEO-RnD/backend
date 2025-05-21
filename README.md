## Pre-commit Hooks

Before every commit, the following checks run:

- ✅ `spotless:check` for formatting
- ✅ `checkstyle:check` for style violations

To fix formatting:
```bash
mvn spotless:apply
```