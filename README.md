Package Purposes

1. application
   Purpose: Orchestrates use cases; coordinates domain logic with infrastructure.
   port.in → Interfaces for commands from the outside world (e.g., REST, CLI, messaging).
   port.out → Interfaces for talking to external systems (DB, APIs, etc.).
   service → Implements the port.in interfaces, calling domain and port.out.

2. domain
   Purpose: Pure business logic — no Spring, no JPA, no external libs.
   model → Entities, value objects, aggregates.
   service → Domain services (pure logic that doesn’t belong to one entity).

3. infrastructure
   Purpose: Implements port.out interfaces, talks to the real world.
   persistence → JPA/Hibernate repositories, database mappings.
   messaging → Kafka consumers/producers.
   rest → REST controllers (they call application.port.in interfaces).
   config → Spring Boot configs (Beans, properties, etc.).

4. shared
   Purpose: Common helpers that are not business logic.
   Example: Exceptions, utilities, enums, constants, logging helpers.


Rule of Thumb:

    domain = rules
    application = orchestration
    infrastructure = real-world connections
    shared = general helpers