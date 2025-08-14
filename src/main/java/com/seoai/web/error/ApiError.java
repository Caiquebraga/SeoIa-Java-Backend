package com.seoai.web.error;

import java.time.OffsetDateTime;

public record ApiError(String message, String path, OffsetDateTime timestamp) {}
