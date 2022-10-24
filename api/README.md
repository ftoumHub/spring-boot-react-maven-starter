This project was bootstrapped with [Spring Boot](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `mvn spring-boot:run`

Runs the backend in the development mode.<br />
Open [http://localhost:3500/api/products](http://localhost:3500/api/products) to view the list of products in the browser.

#### Pagination support

##### Requesting a Page of Data

`http://localhost:3500/api/products?category_like=watersports&_page=2&_limit=3&_sort=name`

The query string for this URL—the part that follows the ? character—asks the web service to return a
page of products from a specific category, using the fields described in Table 6-1.

Table 6-1. The Query String Fields Required for Pagination
Name            Description
category_like   This field filters the results to include only those objects whose category property
                matches the field value, which is Watersports in the example URL. If the category field
                is omitted, then products from all categories will be included in the results.
_page           This field selects the page number.
_limit          This field selects the page size.
_sort           This field specifies the property by which the objects will be sorted before being paginated.


##### Making a Simpler Pagination Request
`http://localhost:3500/api/products?_page=2&_limit=3`