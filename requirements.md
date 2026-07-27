# Software Requirements Specification (SRS)

## UML Requirements Annotation Platform (URAP)

**Version:** 1.0  
**Date:** July 2025  
**Document Type:** Software Requirements Specification (IEEE 29148-2018)

# 1. Introduction

## 1.1 Purpose

The purpose of this document is to define the requirements for the **UML Requirements Annotation Platform (URAP)**, a web-based annotation system specifically designed to create high-quality datasets for software engineering research.

Unlike general-purpose annotation tools (e.g., Doccano), URAP allows a single software requirement specification (SRS) to be annotated with one or more UML diagrams represented in **StarUML textual notation (PlantUML-compatible or StarUML JSON/XMI export in future versions)**.

The platform is intended to create gold-standard datasets for:

- UML diagram generation
- Large Language Model fine-tuning
- Requirements Engineering
- Information Extraction
- Semantic Parsing
- AI-assisted Software Design
- Automated UML Generation

## 1.2 Scope

URAP enables users to

- import software requirements
- organize annotation projects
- assign annotators
- annotate requirements with UML models
- validate annotations
- compare multiple annotators
- measure inter-annotator agreement
- export datasets for machine learning

Unlike Doccano, whose annotation unit is a sequence of labeled tokens, URAP's annotation unit is an entire software requirement together with one or more UML models.

## 1.3 Intended Users

- Requirements Engineers
- Software Architects
- Business Analysts
- UML Experts
- Researchers
- Dataset Curators
- Machine Learning Engineers
- Students

# 2. Overall Description

## 2.1 Product Perspective

The application is a specialized annotation platform inspired by Doccano.

Instead of assigning entities or relations, users assign UML diagrams.

```shell
Requirement
      │
      │
      ▼
+-----------------------+
| UML Annotation Editor |
+-----------------------+
      │
      ├───────────────► Use Case Diagram
      │
      ├───────────────► Class Diagram
      │
      ├───────────────► Activity Diagram
      │
      ├───────────────► Sequence Diagram
      │
      ├───────────────► State Machine Diagram
      │
      ├───────────────► Communication Diagram
      │
      ├───────────────► Timing Diagram
      │
      ├───────────────► Interaction Overview Diagram
      │
      ├───────────────► Component Diagram
      │
      ├───────────────► Deployment Diagram
      │
      ├───────────────► Package Diagram
      │
      ├───────────────► Composite Structure Diagram
      │
      ├───────────────► Object Diagram
      │
      └───────────────► Profile Diagram
```

# 3. Product Functions

The system shall support

- project management
- dataset management
- annotation management
- UML editor
- validation
- review workflow
- quality metrics
- export
- user management

# 4. User Roles

## Administrator

- Creates projects
- Creates users
- Assigns annotators
- Defines annotation guidelines
- Exports datasets
- Views statistics

## Project Manager

- Creates projects
- Creates datasets
- Imports requirements
- Assigns work
- Monitors progress
- Approves annotations

## Annotator

- Reads requirements
- Chooses UML diagram types
- Writes UML models
- Saves annotations
- Marks completion

## Reviewer

- Reviews annotations
- Approves
- Rejects
- Requests changes
- Measures quality

## Researcher

- Exports datasets
- Downloads annotations
- Runs statistics
- Generates reports

# 5. Functional Requirements

## FR-001 Create Project

The system shall allow users to create annotation projects.

Inputs

- name
- description
- language
- UML version
- annotation guidelines

Outputs

- project identifier

## FR-002 Import Requirements

Supported formats

- TXT
- CSV
- JSON
- JSONL
- XML
- PDF
- DOCX

Each imported requirement becomes one annotation task.

## FR-003 Requirement Viewer

- Display
- Requirement ID
- Requirement text
- Metadata
- Previous annotations
- History

## FR-004 UML Diagram Selection

For every requirement, an annotator may choose one or more UML diagram types.

Supported diagrams

| UML Diagram          |
| -------------------- |
| Use Case             |
| Class                |
| Activity             |
| Sequence             |
| State Machine        |
| Communication        |
| Timing               |
| Interaction Overview |
| Package              |
| Component            |
| Composite Structure  |
| Object               |
| Deployment           |
| Profile              |

---

## FR-005 UML Editor

Each selected UML diagram opens an editor.

Features

- syntax highlighting
- auto completion
- line numbers
- UML validation
- code folding
- search
- undo
- redo
- split editor

## FR-006 StarUML Representation

The editor shall accept StarUML textual notation.

Example

```startuml
@startuml

actor RepositoryManager

RepositoryManager --> (View Collections)

RepositoryManager --> (View Objects)

@enduml
```

## FR-007 Multiple UML Models

A single requirement may contain

0...

14 UML diagrams.

Each diagram is stored independently.

## FR-008 UML Syntax Validation

Before saving

the system validates

- syntax
- completeness
- duplicated elements
- invalid references

Errors are shown immediately.

## FR-009 UML Preview

The system renders UML diagrams.

```
Editor
──────────────
PlantUML Text

↓

Generated Diagram

↓

Validation
```

## FR-010 Auto Save

Automatically save every configurable interval (e.g., 30 seconds).

## FR-011 Annotation Status

States

```text
Not Started

↓

In Progress

↓

Completed

↓

Reviewed

↓

Approved
```

---

## FR-012 Comments

- Reviewers may
- highlight lines
- write comments
- mention users
- resolve discussions

## FR-013 Version History

- Every save creates a new revision.
- Users can compare revisions.
- Restore revisions.

## FR-014 Assignment

- Assig
- project
- requirement
- reviewer
- annotator

## FR-015 Dataset Export

- Formats
- JSON
- JSONL
- CSV
- XML
- CoNLL
- Parquet
- SQLite

## FR-016 Machine Learning Export

Export

```
Requirement

+

Class Diagram

+

Use Case Diagram

+

Activity Diagram

...

↓

Training Example
```

Example JSON

```json
{
  "id": 1,
  "text": "As a repository manager...",
  "annotations": [
    {
      "diagram": "UseCase",
      "uml": "@startuml..."
    },
    {
      "diagram": "Class",
      "uml": "@startuml..."
    }
  ]
}
```

## FR-017 Search

- Search by
- project
- user
- diagram
- keyword
- status
- date
- entity

## FR-018 Statistics

- Dashboard
- Projects
- Requirements
- Completed
- Pending
- Agreement
- Average annotation time
- Diagram frequency

## FR-019 Inter-Annotator Agreement

- Metrics
- Cohen's κ
- Fleiss κ
- Krippendorff α
- Exact Match
- Diagram Similarity
- Tree Edit Distance

## FR-020 Annotation Guidelines

- Rich text editor
- Images
- Videos
- Examples
- Templates

# 6. Nonfunctional Requirements

## Performance

- Support
- 100 concurrent users
- Response < 2 seconds
- Render UML < 1 second
- Autosave < 300 ms

## Availability

99.9%

## Security

- JWT
- OAuth2
- LDAP
- RBAC
- HTTPS
- Encryption at rest

## Scalability

- Support
- 1 million requirements
- 100 million annotations

## Portability

- Docker
- Docker Compose
- Kubernetes
- Linux
- Windows
- macOS

## Reliability

- Automatic backup
- Recovery
- Transaction logging
- Version history

# 7. Data Model (MongoDB)

The application shall use MongoDB as its primary data store. Data shall be organized into collections that represent the major aggregates of the annotation platform.

## 7.1 Collections

The system shall maintain the following collections:

| Collection      | Description                                   |
| --------------- | --------------------------------------------- |
| `users`         | User accounts and authentication information  |
| `projects`      | Annotation projects                           |
| `requirements`  | Software requirements imported into a project |
| `annotations`   | UML annotations created for each requirement  |
| `reviews`       | Review decisions and reviewer comments        |
| `guidelines`    | Annotation guidelines for projects            |
| `activity_logs` | User activity and audit logs                  |
| `exports`       | Export history                                |
| `settings`      | Global application configuration              |

# 7.2 Users Collection

```json
{
  "_id": ObjectId,
  "username": "jdoe",
  "fullName": "John Doe",
  "email": "john@company.com",
  "passwordHash": "...",
  "role": "Annotator",
  "status": "Active",
  "createdAt": ISODate(),
  "updatedAt": ISODate()
}
```

# 7.3 Projects Collection

```json
{
  "_id": ObjectId,
  "name": "DAMS Requirements",
  "description": "Requirements for DAMS",
  "language": "en",
  "umlVersion": "2.5",
  "annotationGuidelineId": ObjectId,
  "createdBy": ObjectId,
  "annotators": [
      ObjectId,
      ObjectId
  ],
  "reviewers": [
      ObjectId
  ],
  "statistics": {
      "requirements": 1250,
      "completed": 532,
      "approved": 210
  },
  "createdAt": ISODate(),
  "updatedAt": ISODate()
}
```

# 7.4 Requirements Collection

Each document represents one software requirement.

```json
{
  "_id": ObjectId,
  "projectId": ObjectId,
  "requirementId": "REQ-000145",
  "text": "As a repository manager, I want to know all the collections and objects in the DAMS for which I have custodial responsibility.",
  "source": {
      "fileName": "requirements.pdf",
      "page": 12,
      "section": "4.2"
  },

  "metadata": {
      "priority": "High",
      "type": "Functional",
      "language": "English"
  },
  "status": "In Review",
  "assignedTo": ObjectId,
  "annotationCount": 5,
  "createdAt": ISODate(),
  "updatedAt": ISODate()
}
```

# 7.5 Annotations Collection

Each UML diagram is stored as an independent document.

This allows:

- multiple annotators
- multiple diagram types
- unlimited revisions
- independent review
- efficient querying

```json
{
  "_id": ObjectId,
  "requirementId": ObjectId,
  "projectId": ObjectId,
  "diagramType": "Class Diagram",
  "umlLanguage": "StarUML",
  "umlText": "...",
  "renderedImage": "/storage/diagram.png",
  "version": 4,
  "status": "Approved",
  "annotatorId": ObjectId,
  "reviewerId": ObjectId,
  "reviewDecision": "Approved",
  "reviewComments": [
      {
          "author": ObjectId,
          "text": "Missing multiplicity.",
          "createdAt": ISODate()
      }

  ],
  "createdAt": ISODate(),
  "updatedAt": ISODate()
}
```

---

# 7.6 Annotation Versions Collection

Rather than modifying previous versions, every save creates a new immutable version.

```json
{
  "_id": ObjectId,
  "annotationId": ObjectId,
  "version": 4,
  "umlText": "...",
  "authorId": ObjectId,
  "changeSummary": "Added Collection class.",
  "createdAt": ISODate()
}
```

# 7.7 Reviews Collection

```json
{
  "_id": ObjectId,
  "annotationId": ObjectId,
  "reviewerId": ObjectId,
  "decision": "Needs Changes",
  "comments": [
      {
        "line": 10,
        "text": "Association missing.",
        "resolved": false
      }
  ],

  "createdAt": ISODate()
}
```

# 7.8 Guidelines Collection

```json
{
  "_id": ObjectId,
  "projectId": ObjectId,
  "title": "Class Diagram Guidelines",
  "content": "...",
  "version": 3,
  "createdAt": ISODate()
}
```

# 7.9 Activity Logs Collection

```json
{
  "_id": ObjectId,
  "userId": ObjectId,
  "projectId": ObjectId,
  "action": "CREATE_ANNOTATION",
  "resourceId": ObjectId,
  "resourceType": "Annotation",
  "timestamp": ISODate(),
  "details": {
      "diagramType": "Class Diagram"
  }
}
```

# 7.10 Exports Collection

```json
{
  "_id": ObjectId,
  "projectId": ObjectId,
  "createdBy": ObjectId,
  "format": "JSONL",
  "fileName": "dataset.jsonl",
  "recordCount": 2500,
  "downloadUrl": "...",
  "createdAt": ISODate()
}
```

# 7.11 Relationships

```shell
Project
 ├── Requirements (1:N)
 ├── Users (N:M)
 └── Guidelines (1:N)

Requirement
 ├── Annotations (1:N)
 └── Assigned Annotator (N:1)

Annotation
 ├── Versions (1:N)
 ├── Reviews (1:N)
 └── Reviewer (N:1)

User
 ├── Projects
 ├── Annotations
 ├── Reviews
 └── Activity Logs
```

# 7.12 Recommended Indexes

### `requirements`

```shell
db.requirements.createIndex({ projectId: 1 })
db.requirements.createIndex({ status: 1 })
db.requirements.createIndex({ assignedTo: 1 })
db.requirements.createIndex({ requirementId: 1 }, { unique: true })
db.requirements.createIndex({ text: "text" })
```

### `annotations`

```shell
db.annotations.createIndex({ requirementId: 1 })
db.annotations.createIndex({ projectId: 1 })
db.annotations.createIndex({ diagramType: 1 })
db.annotations.createIndex({ annotatorId: 1 })
db.annotations.createIndex({ reviewerId: 1 })
db.annotations.createIndex({ status: 1 })
db.annotations.createIndex(
    { requirementId: 1, diagramType: 1, version: -1 }
)
```

### `projects`

```shell
db.projects.createIndex({ name: 1 })
```

### `users`

```shell
db.users.createIndex({ username: 1 }, { unique: true })
db.users.createIndex({ email: 1 }, { unique: true })
```

## Design Rationale

This MongoDB schema follows a **hybrid document model**:

- **Embedding** is used for small, tightly coupled data (e.g., project statistics, source metadata, review comments).
- **Referencing** is used for high-growth entities (e.g., requirements, annotations, versions, reviews) to avoid oversized documents and support independent lifecycles.
- Each UML annotation is stored as a separate document, enabling multiple annotators, multiple UML diagram types per requirement, concurrent editing, and complete version history.
- Immutable annotation versions preserve provenance and support dataset reproducibility, which is especially important for AI training and inter-annotator agreement studies. This design scales well to millions of requirements and annotations while remaining efficient for the platform's primary queries.

# 8. External Interfaces

## REST API

```shell
POST /projects
POST /requirements
GET /requirements
POST /annotations
PUT /annotations/{id}
GET /annotations
POST /reviews
GET /statistics
```

## Import API

CSV
JSON
JSONL
PDF
DOCX

---

## Export API

JSON
JSONL
CSV
XML
Parquet
SQLite

# 9. Example Annotation

Requirement

```txt
As a repository manager, I want to know all the collections and objects in the DAMS for which I have custodial responsibility.
```

Annotations

```
✓ Use Case Diagram

✓ Class Diagram

✓ Activity Diagram

✓ Sequence Diagram

✓ Package Diagram

...
```

Use Case

```
@startuml

actor RepositoryManager

usecase "View Collections" as UC1
usecase "View Objects" as UC2

RepositoryManager --> UC1
RepositoryManager --> UC2

@enduml
```

Class Diagram

```
@startuml

class RepositoryManager
class Collection
class Object
class DAMS

RepositoryManager --> Collection
RepositoryManager --> Object
Collection --> DAMS
Object --> DAMS

@enduml
```

---

# 10. Future Enhancements

- AI-assisted UML generation with editable suggestions.
- Automatic UML consistency checking across multiple diagrams.
- Integration with Git repositories for version-controlled requirements.
- Support for XMI import/export and round-trip engineering with StarUML.
- Active learning to prioritize requirements needing human review.
- Custom annotation schemas for SysML, BPMN, ArchiMate, and ER diagrams.
- Plugin architecture for additional modeling languages.
- Fine-grained provenance tracking for research reproducibility.
- Built-in benchmark generation and dataset versioning.

## Appendix A: Recommended Technology Stack

| Layer            | Recommended Technology             |
| ---------------- | ---------------------------------- |
| Frontend         | React + TypeScript + Monaco Editor |
| UI Components    | Material UI or Ant Design          |
| UML Rendering    | PlantUML Server or Kroki           |
| Backend          | FastAPI (Python)                   |
| Authentication   | Keycloak or JWT/OAuth2             |
| Database         | PostgreSQL                         |
| Cache/Queue      | Redis + Celery                     |
| Object Storage   | MinIO or Amazon S3                 |
| Search           | OpenSearch or Elasticsearch        |
| API              | REST (with optional GraphQL)       |
| Containerization | Docker + Docker Compose            |
| Orchestration    | Kubernetes (optional)              |
| Monitoring       | Prometheus + Grafana               |
| Logging          | Loki + Grafana or ELK Stack        |
| CI/CD            | GitHub Actions or GitLab CI        |

This architecture provides a strong foundation for a Doccano-like platform specialized for UML annotation while remaining scalable for building large, high-quality datasets for AI-assisted software engineering research.

---

I have a Jhipster application with the next configuration:

```json
{
  "generator-jhipster": {
    "applicationType": "monolith",
    "authenticationType": "jwt",
    "baseName": "spec2Uml",
    "buildTool": "maven",
    "cacheProvider": null,
    "clientFramework": "react",
    "clientTestFrameworks": [],
    "clientTheme": "pulse",
    "clientThemeVariant": "primary",
    "creationTimestamp": 020299393,
    "databaseType": "mongodb",
    "defaultCommand": "app",
    "devDatabaseType": null,
    "enableHibernateCache": null,
    "enableTranslation": true,
    "entities": [],
    "feignClient": null,
    "jhipsterVersion": "9.2.0",
    "jwtSecretKey": "thekey",
    "languages": ["en", "es"],
    "microfrontend": null,
    "microfrontends": [],
    "nativeLanguage": "en",
    "packageName": "com.github.danimaniarqsoft",
    "prodDatabaseType": null,
    "reactive": true,
    "serverPort": null,
    "serviceDiscoveryType": null,
    "syncUserWithIdp": null,
    "testFrameworks": ["cucumber"],
    "withAdminUi": true
  }
}
```

I want to create an application that let us annotate software requirements especifications with the startuml text. This applications is going to have the next modules:
