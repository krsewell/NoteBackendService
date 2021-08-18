# Note Backend Service
> Implements a Restful Api to store abstract text resources. 
> Backend could be used for a variety of text based documents and retrieved via JSON. 
> Spring Boot Jpa and Data are used for ORM, while Maven was used for dependency management.

##Feature List
- C.R.U.D. Text Record Management
- Batch Operations

###Planned  Features
- Implement word count algorithm.
- Transition record lookup to document ID, from table id lookup
- Stale record data checks, prior to updating record.
- Migrate updates (Patch) operations from 1 Row per record, to 1 row per record version.
- Provide endpoint to undo/redo record changes
- Provide endpoint to fork a record
- Record pruning, either automated or endpoint controlled
- Add author field to records linked to a profile
- Authentication system for users
- Record permissions

---
## Record Structure
User generated fields include title, content, and license field. Any field maybe omitted when creating the record.
```json
{
  "title": "a title",
  "content": "a detailed content to store in a table.",
  "license": "MIT"
}
```

A returned response will add several generated fields for the document.

```json
{
  "title": "a title",
  "content": "a detailed record to store in a table.",
  "license": "MIT",
  "createdAt": 1628876704140,
  "updatedAt": 1628876704140,
  "documentId": "ssQyxjpz3hSBzKQ_l3Tef",
  "wordCount": 8
}
```

---
## Usage

###Single Record Operations
Retrieves a record given its ID.
```http request
GET ...api/records/<id>
``` 

Creates a new record
```http request
POST ...api/records
``` 

Selectively updates, record fields given the records ID.
```http request
PATCH ...api/records/<id>
``` 

Removes the record permanently.
```http request
DELETE ...api/records/<id>
``` 

###Batch Record Operations
Returns a JSON Array of records.
```http request
GET ...api/records
``` 

Creates multiple records, contained within a JSON Array.
```http request
POST ...api/records/batch
```

Updates multiple records, contained within a JSON Array.
```http request
PATCH ...api/records/batch
```


---
## Support

Reach out to me at one of the following places!

- Linkedin at <a href="http://linkedin.com/in/krsewell" target="_blank">`in/krsewell`</a>
- Twitter at <a href="http://twitter.com/sewellkris" target="_blank">`@sewellkris`</a>

---
