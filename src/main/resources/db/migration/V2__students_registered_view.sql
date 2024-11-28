CREATE OR REPLACE VIEW student_comments_view AS
SELECT
    c.id AS comment_id,
    s.full_name AS student_name,
    c.course_name,
    c.description
FROM
    comments c
        JOIN
    student s
    ON
        c.student_id = s.id;
